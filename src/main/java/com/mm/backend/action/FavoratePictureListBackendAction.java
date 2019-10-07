package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@ApiModel(value = "获取收藏图片列表接口")
public class FavoratePictureListBackendAction {
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
