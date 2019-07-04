package com.mm.backend.controller;

import com.mm.backend.action.FavoratePictureBackendAction;
import com.mm.backend.action.FavorateVideoBackendAction;
import com.mm.backend.action.PictureListBackendAction;
import com.mm.backend.action.VideoListBackendAction;
import com.mm.backend.common.PageInfo;
import com.mm.backend.common.RestResult;
import com.mm.backend.vo.PictureListBackendVo;
import com.mm.backend.vo.VideoListBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VideoBackendController
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 21:53
 */

@RestController
@RequestMapping(value = "/backend/video")
@Api(tags = "视频相关API")
public class VideoBackendController {
    @RequestMapping(value = "/list",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "视频列表", notes = "视频列表")
    RestResult<PageInfo<VideoListBackendVo>> videoList(@RequestBody @Validated VideoListBackendAction action) {
        PageInfo<VideoListBackendVo> page = new PageInfo<VideoListBackendVo>();
        return RestResult.createBySuccess(page);
    }

    @RequestMapping(value = "/favorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "收藏视频", notes = "收藏视频")
    RestResult<Void> favorateVideo(@RequestBody @Validated FavorateVideoBackendAction action) {
        return RestResult.createBySuccess();
    }

    @RequestMapping(value = "/unfavorate",method = RequestMethod.POST,
            headers="Content-Type=application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
    @ApiOperation(value = "取消收藏视频", notes = "取消收藏视频")
    RestResult<Void> unfavorateVideo(@RequestBody @Validated FavorateVideoBackendAction action) {
        return RestResult.createBySuccess();
    }
}
