package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName VideoListBackendAction
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 21:59
 */
@Data
@ApiModel(value = "视频列表接口")
public class VideoListBackendAction {
    /**
     *  分页码数
     */
    @Min(1)
    @ApiModelProperty(value = "分页码数", example = "1")
    private  Integer pageNum = 1;


    /**
     *  分页大小
     */
    @Min(1)
    @ApiModelProperty(value = "分页大小", example = "10")
    private  Integer pageSize = 10;
}
