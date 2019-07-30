package com.mm.backend.controller;

import com.mm.backend.action.OrderRequestBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.action.PrepayBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.interceptor.AuthInterceptor;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.service.OrderBackendService;
import com.mm.backend.service.ProductBackendService;
import com.mm.backend.vo.OrderRequestBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.PrepayBackendVo;
import com.mm.backend.vo.ProductBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PayBackendController
 * @Description TODO
 * @Date 2019/7/4 15:44
 */

@Controller
@RequestMapping(value = "/backend/order")
@Api(tags = "订单相关API")
public class OrderBackendController {
    private static final Logger logger =  LoggerFactory.getLogger(OrderBackendController.class);

    @Autowired
    ProductBackendService productBackendService;

    @Autowired
    OrderBackendService orderBackendService;

    @RequestMapping(value = "/productList",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "商品列表", notes = "商品列表")
    RestResult<List<ProductBackendVo>> productList() {
        List<ProductBackendVo> productBackendVos = productBackendService.productList();
        return RestResult.createBySuccess(productBackendVos);
    }

    @RequestMapping(value = "/orderRequest",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ResponseBody
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

    @RequestMapping(value = "/prepay",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "支付预处理", notes = "支付预处理")
    RestResult<PrepayBackendVo> prepay(@RequestBody @Validated PrepayBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        try {
            PrepayBackendVo prepayBackendVo = orderBackendService.prepay(uid, action.getOrderid(),action.getIstype());
            return RestResult.createBySuccess(prepayBackendVo);
        }catch (Exception e) {
            return RestResult.createByErrorMessage(e.getMessage());
        }
    }

    @RequestMapping(value = "/notify",method = RequestMethod.POST,
            headers="Content-Type=application/x-www-form-urlencoded;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "支付成功回调", notes = "支付成功回调")
    RestResult<Void> notify(@RequestParam Map<String, String> params) {
        if(orderBackendService.notify(params)) {
            return RestResult.createBySuccess();
        } else {
            return RestResult.createByError();
        }
    }

    @RequestMapping(value = "/returnUrl",method = RequestMethod.GET,
            headers="Content-Type=application/x-www-form-urlencoded;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "支付成功跳转页面", notes = "支付成功跳转页面")
    String returnUrl(@RequestParam(required = true) String orderid, ModelMap map) {
        return orderBackendService.returnUrl(orderid, map);
    }
}
