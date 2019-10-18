package com.mm.backend.service;

import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.vo.OrderRequestBackendVo;
import com.mm.backend.vo.PrepayBackendVo;
import org.springframework.ui.ModelMap;

import java.util.Map;

/**
 * @ClassName OrderBackendService
 * @Description TODO
 * @Date 2019/7/9 15:42
 */
public interface OrderBackendService {
    OrderRequestBackendVo orderRequest(Integer userId, Integer productId) throws BusinessException;

    PrepayBackendVo prepay(Integer userId, Integer orderId, Integer istype) throws BusinessException;

    boolean notify(Map<String, String> notifyParams);

    String returnUrl(String orderId, ModelMap map);
}
