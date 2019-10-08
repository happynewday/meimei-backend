package com.mm.backend.service.imp;

import com.mm.backend.common.StringUtils;
import com.mm.backend.dao.UserMapper;
import com.mm.backend.pojo.User;
import com.mm.backend.redis.RedisService;
import com.mm.backend.service.UserBackendService;
import com.mm.backend.vo.UserBackendVo;
import com.mm.backend.vo.assemble.UserAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/8 10:05
 */
@Service
public class UserBackendServiceImpl implements UserBackendService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    public UserBackendVo    userRegist(String uuid, String username, String password) throws Exception{
        User user = userMapper.selectByUsername(username);
        if(null != user){
            throw new Exception("该账号已存在");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword =  passwordEncoder.encode(password);
        //String encodedPassword = password;
        String token = StringUtils.randomString(64);
        long time = System.currentTimeMillis();

        user = User.builder().
                uuid(uuid).
                username(username).
                password(encodedPassword).
                accessToken(token).
                createTime(time).
                build();

        if(0 == userMapper.insertSelective(user)){
            throw new Exception("添加用户失败");
        }
        user = userMapper.selectByUsername(username);

        redisService.set(token, user.getId().toString(), 86400 * 30);

        return UserAssembleHelper.assembleUserAuthInfo(user);
    }

    public UserBackendVo login(String username, String password, String uuid) throws Exception {
        User user = userMapper.selectByUsername(username);
        if(null == user){
            throw new Exception("用户不存在");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            throw new Exception("密码错误");
        }

        //绑定账号和uuid
        if(StringUtils.isNotBlank(uuid)){
            if(StringUtils.isBlank(user.getUuid())){
                user.setUuid(uuid);
            }
        }

        //生成用户token
        String oldToken = user.getAccessToken();
        String token = StringUtils.randomString(64);
        user.setAccessToken(token);
        userMapper.updateByPrimaryKeySelective(user);

        //更新redis
        redisService.del(oldToken);
        redisService.set(token, user.getId().toString() + ":" + user.getLevel().toString(), 86400 * 30);

        return UserAssembleHelper.assembleUserAuthInfo(user);
    }

    public UserBackendVo getUserInfo(Integer uid, String uuid) throws RuntimeException{
        User user;
        if(null != uid) {
            user = userMapper.selectByPrimaryKey(uid);
            if(null == user){
                throw new RuntimeException("用户不存在");
            }
        } else {
            user = userMapper.selectByUuid(uuid);
            if(null == user){
                long time = System.currentTimeMillis();
                user = User.builder().
                        uuid(uuid).
                        createTime(time).
                        build();

                if(0 == userMapper.insertSelective(user)){
                    throw new RuntimeException("添加用户失败");
                }
            }
            user = userMapper.selectByUuid(uuid);
        }
        return UserAssembleHelper.assembleUserAuthInfo(user);
    }
}
