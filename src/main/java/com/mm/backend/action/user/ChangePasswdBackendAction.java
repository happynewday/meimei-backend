package com.mm.backend.action.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "修改密码")
public class ChangePasswdBackendAction {
    /**
     *  新密码
     */
    @ApiModelProperty(value = "新密码", example = "abc")
    private  String passwd;
}
