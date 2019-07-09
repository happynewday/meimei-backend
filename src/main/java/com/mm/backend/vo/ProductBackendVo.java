package com.mm.backend.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ProductBackendVo
 * @Description TODO
 * @Date 2019/7/9 15:07
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBackendVo {
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Integer id;

    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private String name;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String desc;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private double price;
}
