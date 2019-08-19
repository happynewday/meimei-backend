package com.mm.backend.action.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName UserInfoBackendAction
 * @Description TODO
 * @Date 2019/8/19 14:20
 */

@Data
@ApiModel(value = "用户详情接口")
public class UserInfoBackendAction {
    /**
     *  用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "123")
    private  Integer uid;

    /**
     *  唯一设备ID
     */
    @ApiModelProperty(value = "唯一设备ID", example = "ab1cf")
    private  String uuid;
}
