package com.mm.backend.controller;

import com.mm.backend.action.FavoratePictureBackendAction;
import com.mm.backend.action.PictureCollectDetailBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.action.RegistUserBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.service.PictureBackendService;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.UserBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PictureBackendController
 * @Description TODO
 * @Date 2019/7/3 20:43
 */

@RestController
@RequestMapping(value = "/backend/picture")
@Api(tags = "图集相关API")
public class PictureBackendController {

    @Autowired
    private PictureBackendService pictureBackendService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "图集列表", notes = "图集列表")
    RestResult<PageInfo<PictureListBackendVo>> collectList(@RequestBody @Validated PictureListBackendAction action) {
        PageInfo<PictureListBackendVo> page = pictureBackendService.getPictureCollectList(action.getPageNum(), action.getPageSize());
        return RestResult.createBySuccess(page);
    }

    @RequestMapping(value = "/collectDetail",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "图集详情", notes = "图集详情")
    RestResult<PictureCollectDetailBackendVo> collectDetail(@RequestBody @Validated PictureCollectDetailBackendAction action) {
        PictureCollectDetailBackendVo p = new PictureCollectDetailBackendVo();
        return RestResult.createBySuccess(p);
    }

    @RequestMapping(value = "/favorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "收藏图集", notes = "收藏图集")
    RestResult<Void> favoratePicture(@RequestBody @Validated FavoratePictureBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        boolean ret = pictureBackendService.addFavoratePicture(uid, action.getId());
        if(ret) {
            return RestResult.createBySuccess();
        } else {
            return RestResult.createByError();
        }
    }

    @RequestMapping(value = "/unfavorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "取消收藏图集", notes = "取消收藏图集")
    RestResult<Void> unfavoratePicture(@RequestBody @Validated FavoratePictureBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        boolean ret = pictureBackendService.removeFavoratePicture(uid, action.getId());
        if(ret) {
            return RestResult.createBySuccess();
        } else {
            return RestResult.createByError();
        }
    }
}
