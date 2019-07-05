package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ClassName ThirdLoginBackendAction
 * @Description TODO
 * @Date 2019/7/3 17:16
 */

@Data
@ApiModel(value = "三方登录接口")
public class ThirdLoginBackendAction {
    /**
     * openID
     */
    @NotBlank
    @ApiModelProperty(value = "第三方的用户唯一标识，用来做二次校验", example = "afjefa")
    private String openId;

    /**
     * access_token
     */
    @NotBlank
    @ApiModelProperty(value = "access_token, 第三方的接口调用凭证，用来做二次校验", example = "afjefa")
    private String access_token;

    /**
     * avatar
     */
    @NotBlank
    @ApiModelProperty(value = "头像", example = "www.qq.com/a.jpg")
    private String avatar;

    /**
     * nickname
     */
    @NotBlank
    @ApiModelProperty(value = "昵称", example = "小花花")
    private String nickname;
}
