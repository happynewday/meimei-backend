package com.mm.backend.controller;

import com.mm.backend.action.LoginBackendAction;
import com.mm.backend.action.RegistUserBackendAction;
import com.mm.backend.action.ThirdLoginBackendAction;
import com.mm.backend.action.user.UserInfoBackendAction;
import com.mm.backend.common.RestResult;
import com.mm.backend.service.UserBackendService;
import com.mm.backend.vo.UserBackendVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserBackendController
 * @Description TODO
 * @Date 2019/7/3 16:07
 */


@RestController
@RequestMapping(value = "/backend/user")
@Api(tags = "用户API信息")
public class UserBackendController {

    @Autowired
    private UserBackendService userBackendService;

    @RequestMapping(value = "/regist",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "注册", notes = "注册")
    RestResult<UserBackendVo> registUser(@RequestBody @Validated RegistUserBackendAction action, HttpServletResponse response) {
        try {
            UserBackendVo userInfo = userBackendService.userRegist(action.getUuid(), action.getUsername(), action.getPassword());
            response.setHeader("x-auth-token", userInfo.getAccess_token());
            return RestResult.createBySuccess(userInfo);
        } catch (Exception e){
            return RestResult.createByErrorMessage(e.getMessage());
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "登录", notes = "登录")
    RestResult<UserBackendVo> login(@RequestBody @Validated LoginBackendAction action, HttpServletResponse response) {
        try {
            UserBackendVo userInfo = userBackendService.login(action.getUsername(), action.getPassword(), action.getUuid());
            response.setHeader("x-auth-token", userInfo.getAccess_token());
            return RestResult.createBySuccess(userInfo);
        } catch (Exception e){
            return RestResult.createByErrorMessage(e.getMessage());
        }
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
            return RestResult.createBySuccess(userBackendVo);
        }catch(RuntimeException e){
            return RestResult.createByErrorMessage(e.getMessage());
        }
    }
}
