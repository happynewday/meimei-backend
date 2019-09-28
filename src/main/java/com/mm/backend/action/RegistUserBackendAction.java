package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @ClassName RegistUserBackendAction
 * @Description TODO
 * @Date 2019/7/3 16:31
 */

@Data
@ApiModel(value = "注册用户请求参数信息")
public class RegistUserBackendAction {
    /**
     * 设备ID
     */
    @ApiModelProperty(value = "设备ID", example = "afje")
    private String uuid;

    /**
     * 用户名
     */
    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(value = "手机号", example = "13345678912")
    private String username;

    /**
     * 密码
     */
    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
}
