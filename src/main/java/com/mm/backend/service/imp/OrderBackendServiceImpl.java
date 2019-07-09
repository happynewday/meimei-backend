package com.mm.backend.service.imp;

import com.mm.backend.dao.OrderMapper;
import com.mm.backend.dao.ProductMapper;
import com.mm.backend.pojo.Order;
import com.mm.backend.pojo.Product;
import com.mm.backend.service.OrderBackendService;
import com.mm.backend.vo.OrderRequestBackendVo;
import com.mm.backend.vo.assemble.OrderAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/9 15:42
 */
@Service
public class OrderBackendServiceImpl implements OrderBackendService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public OrderRequestBackendVo orderRequest(Integer userId, Integer productId) throws Exception{
        Product product = productMapper.selectByPrimaryKey(productId);
        if(null == product){
            throw new Exception("商品不存在");
        }
        long time = System.currentTimeMillis();
        Order order = Order.builder()
                .userId(userId)
                .productId(productId)
                .createTime(time)
                .originPrice(product.getPrice())
                .status((short)0)
                .build();
        if(0 == orderMapper.insert(order)){
            throw new Exception("订单生成失败");
        }

        return OrderAssembleHelper.assembleOrderRequest(order);
    }
}
