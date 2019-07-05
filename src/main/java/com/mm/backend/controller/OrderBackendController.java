package com.mm.backend.controller;

import com.mm.backend.action.OrderRequestBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.vo.PictureListBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PayBackendController
 * @Description TODO
 * @Date 2019/7/4 15:44
 */

@RestController
@RequestMapping(value = "/backend/order")
@Api(tags = "订单相关API")
public class OrderBackendController {
    @RequestMapping(value = "/orderRequest",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "下单请求", notes = "下单请求")
    RestResult<PageInfo<PictureListBackendVo>> orderRequest(@RequestBody @Validated OrderRequestBackendAction action) {
        PageInfo<PictureListBackendVo> page = new PageInfo<PictureListBackendVo>();
        return RestResult.createBySuccess(page);
    }
}
