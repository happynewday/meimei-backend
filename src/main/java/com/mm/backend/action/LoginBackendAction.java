package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ClassName LoginBackendAction
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 17:14
 */

@Data
@ApiModel(value = "登陆接口")
public class LoginBackendAction {
    /**
     * 用户名
     */
    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(value = "用户名", example = "13345678912")
    private String username;

    /**
     * 用户名
     */
    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
}
