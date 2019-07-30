package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName PrepayBackendAction
 * @Description TODO
 * @Date 2019/7/28 18:02
 */
@Data
@ApiModel(value = "预支付接口")
public class PrepayBackendAction {
    /**
     *  分页大小
     */
    @Min(1)
    @ApiModelProperty(value = "支付渠道，1：支付宝，2：微信", example = "1")
    private  Integer istype = 1;

    /**
     *  订单号
     */
    @ApiModelProperty(value = "订单号", example = "123")
    private Integer orderid;
}
