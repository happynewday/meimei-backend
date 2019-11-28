package com.mm.backend.controller;

import com.mm.backend.action.*;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.common.UidUtil;
import com.mm.backend.exceptions.BusinessException;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.service.PictureBackendService;
import com.mm.backend.vo.PictureCollectDetailBackendVo;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.UserBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.mm.backend.common.ResponseCode.PICTURE_FAVORATE_FAILED;
import static com.mm.backend.common.ResponseCode.PICTURE_UNFAVORATE_FAILED;

/**
 * @ClassName PictureBackendController
 * @Description TODO
 * @Date 2019/7/3 20:43
 */
@RestController
@RequestMapping(value = "/backend/picture")
@Api(tags = "图集相关API")
public class PictureBackendController {
    private static final Logger logger = LoggerFactory.getLogger(PictureBackendController.class);

    @Autowired
    private PictureBackendService pictureBackendService;

    @RequestMapping(value = "/freePicture",method = RequestMethod.POST,
            produces="application/json;charset=UTF-8")
    @ApiOperation(value = "体验图集详情", notes = "体验图集详情")
    RestResult<PictureCollectDetailBackendVo> freeCollectList() {
        try {
            Integer pickedCollect = pictureBackendService.getPickedCollectId(null);
            PictureCollectDetailBackendVo p = pictureBackendService.getPictureCollectDetails(pickedCollect);
            return RestResult.createBySuccess(p);
        } catch (BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "图集列表", notes = "图集列表")
    RestResult<PageInfo<PictureListBackendVo>> collectList(@RequestBody @Validated PictureListBackendAction action) {
        PageInfo<PictureListBackendVo> page = pictureBackendService.getPictureCollectList(action.getActorId(), action.getTag(), action.getPageNum(), action.getPageSize());
        return RestResult.createBySuccess(page);
    }

    @RequestMapping(value = "/pickedCollect",method = RequestMethod.POST,
            produces="application/json;charset=UTF-8")
    @ApiOperation(value = "随便看看", notes = "随便看看")
    RestResult<PictureCollectDetailBackendVo> pickedCollect() {
        try {
            Integer uid = UidUtil.getUidFromRequest();
            Integer pickedCollect = pictureBackendService.getPickedCollectId(uid);
            PictureCollectDetailBackendVo p = pictureBackendService.getPictureCollectDetails(pickedCollect);
            return RestResult.createBySuccess(p);
        } catch (BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @RequestMapping(value = "/collectDetail",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "图集详情", notes = "图集详情")
    RestResult<PictureCollectDetailBackendVo> collectDetail(@RequestBody @Validated PictureCollectDetailBackendAction action) {
        try {
            PictureCollectDetailBackendVo p = pictureBackendService.getPictureCollectDetails(action.getId());
            return RestResult.createBySuccess(p);
        } catch (BusinessException e){
            return new RestResult<>(e.getErrorCode(), e.getErrorMsg());
        }
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
            return new RestResult<>(PICTURE_FAVORATE_FAILED);
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
            return new RestResult<>(PICTURE_UNFAVORATE_FAILED);
        }
    }

    @RequestMapping(value = "/favoratePictures",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "获取收藏图片列表", notes = "获取收藏图片列表")
    RestResult<PageInfo<PictureListBackendVo>> favorateList(@RequestBody @Validated FavoratePictureListBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        PageInfo<PictureListBackendVo> page = pictureBackendService.getFavorateList(uid, action.getPageNum(), action.getPageSize());
        return RestResult.createBySuccess(page);
    }
}
