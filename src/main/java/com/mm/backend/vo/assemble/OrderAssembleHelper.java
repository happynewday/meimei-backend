package com.mm.backend.vo.assemble;

import com.mm.backend.pojo.Order;
import com.mm.backend.vo.OrderRequestBackendVo;

/**
 * @ClassName OrderAssembleHelper
 * @Description TODO
 * @Date 2019/7/9 15:58
 */
public class OrderAssembleHelper {
    public static OrderRequestBackendVo assembleOrderRequest(Order order){
        return OrderRequestBackendVo.builder()
                .productId(order.getProductId())
                .orderId(order.getId())
                .price(order.getOriginPrice())
                .build();
    }
}
