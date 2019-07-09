package com.mm.backend.vo.assemble;

import com.mm.backend.pojo.Product;
import com.mm.backend.vo.ProductBackendVo;


/**
 * @ClassName ProductAssembleHelper
 * @Description TODO
 * @Date 2019/7/9 15:27
 */
public class ProductAssembleHelper {
    public static ProductBackendVo assembleSingleProduct(Product product){
        return ProductBackendVo.builder()
                .id(product.getId())
                .name(product.getPname())
                .desc(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
