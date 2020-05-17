package com.mm.backend.controller;

import com.mm.backend.action.LoginBackendAction;
import com.mm.backend.action.RegistUserBackendAction;
import com.mm.backend.action.ThirdLoginBackendAction;
import com.mm.backend.action.user.ChangePasswdBackendAction;
import com.mm.backend.action.user.UserInfoBackendAction;
import com.mm.backend.common.RestResult;
import com.mm.backend.common.StringUtils;
import com.mm.backend.common.UidUtil;
import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.redis.RedisService;
import com.mm.backend.service.UserBackendService;
import com.mm.backend.vo.UserBackendVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mm.backend.common.ResponseCode.USER_LOGIN_USER_NOT_LOGIN;

/**
 * @ClassName UserBackendController
 * @Description TODO
 * @Date 2019/7/3 16:07
 */


@RestController
@RequestMapping(value = "/backend/user")
@Api(tags = "用户API信息")
public class UserBackendController {
    private static final Logger logger = LoggerFactory.getLogger(UserBackendController.class);

    @Autowired
    private UserBackendService userBackendService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/regist",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "注册", notes = "注册")
    RestResult<UserBackendVo> registUser(@RequestBody @Validated RegistUserBackendAction action, HttpServletResponse response, HttpServletRequest request) {
        try {
            UserBackendVo userInfo = userBackendService.userRegist(action.getUuid(), action.getUsername(), action.getPassword());
            logger.warn("user regist, username={}, uuid={}, remoteAddr={}", action.getUsername(), action.getUuid(), request.getRemoteAddr());
            userInfo.setValidTime("2020-11-10");
            response.setHeader("x-auth-token", userInfo.getAccess_token());
            return RestResult.createBySuccess(userInfo);
        } catch (BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "登录", notes = "登录")
    RestResult<UserBackendVo> login(@RequestBody @Validated LoginBackendAction action, HttpServletResponse response, HttpServletRequest request) {
        try {
            UserBackendVo userInfo = userBackendService.login(action.getUsername(), action.getPassword(), action.getUuid());
            response.setHeader("x-auth-token", userInfo.getAccess_token());
            logger.warn("user login, username={}, uid={}, remoteAddr={}", action.getUsername(), userInfo.getUserId(), request.getRemoteAddr());
            userInfo.setValidTime("2020-11-10");
            return RestResult.createBySuccess(userInfo);
        } catch (BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ApiOperation(value = "登出", notes = "登出")
    RestResult<Void> logout() {
        String token = RequestHeaderContext.getInstance().getToken();
        redisService.del(token);
        return RestResult.createBySuccess();
    }

    @RequestMapping(value = "/thirdLogin",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "三方登录", notes = "三方登录")
    RestResult<UserBackendVo> thirdLogin(@RequestBody @Validated ThirdLoginBackendAction action) {
        UserBackendVo userInfo = new UserBackendVo();
        return RestResult.createBySuccess(userInfo);
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    RestResult<UserBackendVo> userInfo(@RequestBody @Validated UserInfoBackendAction action) {
        Integer uid = action.getUid();
        String uuid = action.getUuid();
        try {
            UserBackendVo userBackendVo = userBackendService.getUserInfo(uid, uuid);
            userBackendVo.setValidTime("2020-11-10");
            return RestResult.createBySuccess(userBackendVo);
        }catch(BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @RequestMapping(value = "/changePasswd",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    RestResult<Void> changePasswd(@RequestBody @Validated ChangePasswdBackendAction action) {
        Integer uid = UidUtil.getUidFromRequest();
        if(StringUtils.isBlank(uid)){
            return new RestResult<>(USER_LOGIN_USER_NOT_LOGIN);
        }
        String passwd = action.getPassword();
        try{
            userBackendService.changePasswd(uid, passwd);
        }catch(BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
        return RestResult.createBySuccess();
    }
}
