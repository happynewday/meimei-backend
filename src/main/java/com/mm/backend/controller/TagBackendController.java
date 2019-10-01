package com.mm.backend.controller;

import com.mm.backend.common.RestResult;
import com.mm.backend.vo.TagListBackendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/backend/tag")
@Api(tags = "标签相关API")
public class TagBackendController {

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ApiOperation(value = "标签列表", notes = "标签列表")
    RestResult<TagListBackendVo> tagList() {
        TagListBackendVo tagListBackendVo = new TagListBackendVo();
        return RestResult.createBySuccess(tagListBackendVo);
    }
}

