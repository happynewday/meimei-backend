package com.mm.backend.service.imp;

import com.mm.backend.common.StringUtils;
import com.mm.backend.dao.UserMapper;
import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.pojo.User;
import com.mm.backend.redis.RedisService;
import com.mm.backend.service.UserBackendService;
import com.mm.backend.vo.UserBackendVo;
import com.mm.backend.vo.assemble.UserAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mm.backend.common.ResponseCode.*;

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

    public UserBackendVo userRegist(String uuid, String username, String password) throws BusinessException {
        User user = userMapper.selectByUsername(username);
        if(null != user){
            throw new BusinessException(USER_REGIST_ACCOUNT_ALREADY_EXIST);
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
            throw new BusinessException(USER_REGIST_ADD_ACCOUNT_FAILED);
        }
        user = userMapper.selectByUsername(username);

        redisService.set(token, user.getId().toString(), 86400 * 30);

        return UserAssembleHelper.assembleUserAuthInfo(user);
    }

    public UserBackendVo login(String username, String password, String uuid) throws BusinessException {
        User user = userMapper.selectByUsername(username);
        if(null == user){
            throw new BusinessException(USER_LOGIN_ACCOUNT_OR_PASSWD_WRONG);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            throw new BusinessException(USER_LOGIN_ACCOUNT_OR_PASSWD_WRONG);
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
        redisService.set(token, user.getId().toString(), 86400 * 30);

        return UserAssembleHelper.assembleUserAuthInfo(user);
    }

    public UserBackendVo getUserInfo(Integer uid, String uuid) throws BusinessException{
        User user = userMapper.selectByPrimaryKey(uid);
        if(null == user){
            throw new BusinessException(USER_INFO_USER_NOT_EXIST);
        }

        return UserAssembleHelper.assembleUserAuthInfo(user);
    }
}
