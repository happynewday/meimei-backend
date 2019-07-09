package com.mm.backend.service.imp;

import com.mm.backend.dao.ProductMapper;
import com.mm.backend.pojo.Product;
import com.mm.backend.service.ProductBackendService;
import com.mm.backend.vo.ProductBackendVo;
import com.mm.backend.vo.assemble.ProductAssembleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductBackendServiceImpl
 * @Description TODO
 * @Date 2019/7/9 15:24
 */
@Service
public class ProductBackendServiceImpl implements ProductBackendService {
    @Autowired
    private ProductMapper productMapper;

    public List<ProductBackendVo> productList(){
        List<Product> products = productMapper.selectAll();
        List<ProductBackendVo> productVos = new ArrayList<>();
        for(Product product: products){
            productVos.add(ProductAssembleHelper.assembleSingleProduct(product));
        }

        return productVos;
    }
}
