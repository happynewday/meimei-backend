package com.mm.backend.controller;

import com.mm.backend.action.LoginBackendAction;
import com.mm.backend.action.RegistUserBackendAction;
import com.mm.backend.action.ThirdLoginBackendAction;
import com.mm.backend.common.RestResult;
import com.mm.backend.vo.UserBackendVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * @ClassName UserBackendController
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 16:07
 */


@RestController
@RequestMapping(value = "/backend/user")
@Api(tags = "用户API信息")
public class UserBackendController {

    @RequestMapping(value = "/regist",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "注册", notes = "注册")
    RestResult<UserBackendVo> registUser(@RequestBody @Validated RegistUserBackendAction action) {
        UserBackendVo userInfo = new UserBackendVo();
        return RestResult.createBySuccess(userInfo);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "登录", notes = "登录")
    RestResult<UserBackendVo> login(@RequestBody @Validated LoginBackendAction action) {
        UserBackendVo userInfo = new UserBackendVo();
        return RestResult.createBySuccess(userInfo);
    }

    @RequestMapping(value = "/thirdLogin",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "三方登录", notes = "三方登录")
    RestResult<UserBackendVo> login(@RequestBody @Validated ThirdLoginBackendAction action) {
        UserBackendVo userInfo = new UserBackendVo();
        return RestResult.createBySuccess(userInfo);
    }
}
