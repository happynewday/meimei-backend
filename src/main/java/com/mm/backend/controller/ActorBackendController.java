package com.mm.backend.controller;

import com.mm.backend.action.ActorDetailBackendAction;
import com.mm.backend.action.ActorListBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.service.ActorBackendService;
import com.mm.backend.vo.ActorDetailBackendVo;
import com.mm.backend.vo.ActorListBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.ProductBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ActorBackendController
 * @Description TODO
 * @Date 2019/8/7 15:47
 */

@RestController
@RequestMapping(value = "/backend/actor")
@Api(tags = "演员相关API")
public class ActorBackendController {
    @Autowired
    private ActorBackendService actorBackendService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "演员列表", notes = "演员列表")
    RestResult<PageInfo<ActorListBackendVo>> actorList(@RequestBody @Validated ActorListBackendAction action) {
        PageInfo<ActorListBackendVo> actorListBackendVos = actorBackendService.getActorList(action.getPageNum(), action.getPageSize());
        return RestResult.createBySuccess(actorListBackendVos);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "演员详情", notes = "演员详情")
    RestResult<ActorDetailBackendVo> actorDetail(@RequestBody @Validated ActorDetailBackendAction action) {
        Integer actorId = action.getActorId();
        ActorDetailBackendVo actorDetailBackendVo = actorBackendService.getActorDetail(actorId);
        return RestResult.createBySuccess(actorDetailBackendVo);
    }
}
