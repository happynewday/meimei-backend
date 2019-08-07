package com.mm.backend.service.imp;

import com.mm.backend.common.MD5Utils;
import com.mm.backend.common.PayUtils;
import com.mm.backend.dao.OrderMapper;
import com.mm.backend.dao.ProductMapper;
import com.mm.backend.pojo.Order;
import com.mm.backend.pojo.Product;
import com.mm.backend.service.OrderBackendService;
import com.mm.backend.vo.OrderRequestBackendVo;
import com.mm.backend.vo.PrepayBackendVo;
import com.mm.backend.vo.assemble.OrderAssembleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/9 15:42
 */
@Service
public class OrderBackendServiceImpl implements OrderBackendService {
    private static final Logger logger =  LoggerFactory.getLogger(OrderBackendServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private Environment env;

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

    public PrepayBackendVo prepay(Integer userId, Integer orderId, Integer istype) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(null == order){
            throw new Exception("订单不存在");
        }
        Integer productId = order.getProductId();
        Product product = productMapper.selectByPrimaryKey(productId);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("goodsname", product.getPname());
        paramMap.put("istype", istype);
        paramMap.put("orderid", orderId);
        paramMap.put("orderuid", userId);
        paramMap.put("price", product.getPrice());

        //String key = md5(formatedString.toString());
        paramMap = PayUtils.payOrder(paramMap);
        PrepayBackendVo prepayBackendVo = PrepayBackendVo.builder()
                .uid(paramMap.get("uid").toString())
                .istype(istype)
                .price(product.getPrice())
                .notifyUrl(paramMap.get("notify_url").toString())
                .returnUrl(paramMap.get("return_url").toString())
                .goodsname(paramMap.get("goodsname").toString())
                .orderid(paramMap.get("orderid").toString())
                .orderuid(paramMap.get("orderuid").toString())
                .key(paramMap.get("key").toString())
                .build();
        return prepayBackendVo;
    }

    private String md5(String str) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((str).getBytes("UTF-8"));
        byte b[] = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for(int offset=0; offset<b.length; offset++){
            i = b[offset];
            if(i<0){
                i+=256;
            }
            if(i<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }

    public boolean notify(Map<String, String> notifyParams){
        if(PayUtils.checkPayKey(notifyParams)){
            String orderid = notifyParams.get("orderid");
            Order order = orderMapper.selectByPrimaryKey(Integer.parseInt(orderid));
            if(null == order){
                logger.error("[pay notify]order({}) not exists.", orderid);
                return false;
            }
            if(Order.status.INITIAL == order.getStatus()){
                order.setStatus((short)Order.status.PAYED);
                order.setPayTime(System.currentTimeMillis());
                if( 1 != orderMapper.updateByPrimaryKey(order)){
                    logger.error("[pay notify]update order({}) status failed.", orderid);
                    return false;
                }
            }
        } else {
            logger.error("[pay notify]checksum failed, the key from remote is {}", notifyParams.get("key"));
            return false;
        }
        return true;
    }

    public String returnUrl(String orderId, ModelMap paramMap){
        Order order = orderMapper.selectByPrimaryKey(Integer.parseInt(orderId));
        if(null == order){
            logger.error("[pay returnUrl]order({}) not exists.", orderId);
            paramMap.addAttribute("payResult", false);
            return "returnUrl";
        }
        if(order.getStatus() == Order.status.PAYED){
            paramMap.addAttribute("payResult", true);
            return "returnUrl";
        } else {
            paramMap.addAttribute("payResult", false);
            return "returnUrl";
        }
    }
}