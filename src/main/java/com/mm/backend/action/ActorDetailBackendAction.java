package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName ActorDetailBackendAction
 * @Description TODO
 * @Date 2019/8/7 17:26
 */
@Data
@ApiModel(value = "演员详情接口")
public class ActorDetailBackendAction {
    /**
     *  演员ID
     */
    @Min(1)
    @ApiModelProperty(value = "演员ID", example = "1")
    private  Integer actorId;
}
