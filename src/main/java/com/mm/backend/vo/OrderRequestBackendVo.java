package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderRequestBackendVo
 * @Description TODO
 * @Date 2019/7/4 16:45
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequestBackendVo {
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Integer productId;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Double price;
}
