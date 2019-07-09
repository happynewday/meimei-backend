package com.mm.backend.service;

import com.mm.backend.vo.ProductBackendVo;

import java.util.List;

/**
 * @ClassName ProductBackendService
 * @Description TODO
 * @Date 2019/7/9 15:23
 */
public interface ProductBackendService {
    List<ProductBackendVo> productList();
}
