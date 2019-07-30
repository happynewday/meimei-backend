package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName PrepayBackendVo
 * @Description TODO
 * @Date 2019/7/28 18:13
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrepayBackendVo {
    /**
     * 商户uid
     */
    @ApiModelProperty(value = "商户uid")
    private String uid;

    /**
     * 支付渠道
     */
    @ApiModelProperty(value = "支付渠道，1：支付宝；2：微信支付")
    private Integer istype;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Double price;

    /**
     * 通知回调地址
     */
    @ApiModelProperty(value = "通知回调地址")
    private String notifyUrl;

    /**
     * 跳转地址
     */
    @ApiModelProperty(value = "跳转地址")
    private String returnUrl;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsname;

    /**
     * 自定义订单号
     */
    @ApiModelProperty(value = "自定义订单号")
    private String orderid;

    /**
     * 自定义用户ID
     */
    @ApiModelProperty(value = "自定义用户ID")
    private String orderuid;

    /**
     * 支付密钥
     */
    @ApiModelProperty(value = "支付密钥")
    private String key;
}
