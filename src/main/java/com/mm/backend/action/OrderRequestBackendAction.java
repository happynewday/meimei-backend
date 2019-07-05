package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName OrderRequestBackendAction
 * @Description TODO
 * @Date 2019/7/4 15:52
 */

@Data
@ApiModel(value = "下单请求接口")
public class OrderRequestBackendAction {
    /**
     *  商品ID
     */
    @Min(1)
    @ApiModelProperty(value = "商品ID", example = "1")
    private  Integer id;
}
