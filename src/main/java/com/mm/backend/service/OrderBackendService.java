package com.mm.backend.service;

import com.mm.backend.vo.OrderRequestBackendVo;

/**
 * @ClassName OrderBackendService
 * @Description TODO
 * @Date 2019/7/9 15:42
 */
public interface OrderBackendService {
    OrderRequestBackendVo orderRequest(Integer userId, Integer productId) throws Exception;
}
