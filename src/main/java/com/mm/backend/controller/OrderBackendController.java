package com.mm.backend.controller;

import com.mm.backend.action.OrderRequestBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.service.OrderBackendService;
import com.mm.backend.service.ProductBackendService;
import com.mm.backend.vo.OrderRequestBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.ProductBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PayBackendController
 * @Description TODO
 * @Date 2019/7/4 15:44
 */

@RestController
@RequestMapping(value = "/backend/order")
@Api(tags = "订单相关API")
public class OrderBackendController {
    @Autowired
    ProductBackendService productBackendService;

    @Autowired
    OrderBackendService orderBackendService;

    @RequestMapping(value = "/productList",method = RequestMethod.POST)
    @ApiOperation(value = "商品列表", notes = "商品列表")
    RestResult<List<ProductBackendVo>> productList() {
        List<ProductBackendVo> productBackendVos = productBackendService.productList();
        return RestResult.createBySuccess(productBackendVos);
    }

    @RequestMapping(value = "/orderRequest",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "下单请求", notes = "下单请求")
    RestResult<OrderRequestBackendVo> orderRequest(@RequestBody @Validated OrderRequestBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        try {
            OrderRequestBackendVo orderRequestBackendVo = orderBackendService.orderRequest(uid, action.getId());
            return RestResult.createBySuccess(orderRequestBackendVo);
        }catch (Exception e) {
            return RestResult.createByErrorMessage(e.getMessage());
        }
    }
}
