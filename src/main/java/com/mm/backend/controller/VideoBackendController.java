package com.mm.backend.controller;

import com.mm.backend.action.*;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.interceptor.RequestHeaderContext;
import com.mm.backend.service.VideoBackendService;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.VideoDetailBackendVo;
import com.mm.backend.vo.VideoListBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VideoBackendController
 * @Description TODO
 * @Date 2019/7/3 21:53
 */

@RestController
@RequestMapping(value = "/backend/video")
@Api(tags = "视频相关API")
public class VideoBackendController {
    @Autowired
    private VideoBackendService videoBackendService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "视频列表", notes = "视频列表")
    RestResult<PageInfo<VideoListBackendVo>> videoList(@RequestBody @Validated VideoListBackendAction action) {
        PageInfo<VideoListBackendVo> page = videoBackendService.getVideoList(action.getPageNum(), action.getPageSize());
        return RestResult.createBySuccess(page);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "视频列表", notes = "视频列表")
    RestResult<VideoDetailBackendVo> detail(@RequestBody @Validated VideoDetailBackendAction action) {
        try {
            VideoDetailBackendVo videoDetailBackendVo = videoBackendService.getVideoDetails(action.getId());
            return RestResult.createBySuccess(videoDetailBackendVo);
        } catch (Exception e){
            return RestResult.createByErrorMessage(e.getMessage());
        }
    }

    @RequestMapping(value = "/favorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "收藏视频", notes = "收藏视频")
    RestResult<Void> favorateVideo(@RequestBody @Validated FavorateVideoBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        boolean ret = videoBackendService.addFavorateVideo(uid, action.getId());
        if(ret){
            return RestResult.createBySuccess();
        } else {
            return RestResult.createByError();
        }
    }

    @RequestMapping(value = "/unfavorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "取消收藏视频", notes = "取消收藏视频")
    RestResult<Void> unfavorateVideo(@RequestBody @Validated FavorateVideoBackendAction action) {
        Integer uid = Integer.valueOf(RequestHeaderContext.getInstance().getUserId());
        boolean ret = videoBackendService.removeFavorateVideo(uid, action.getId());
        if(ret){
            return RestResult.createBySuccess();
        } else {
            return RestResult.createByError();
        }
    }
}
