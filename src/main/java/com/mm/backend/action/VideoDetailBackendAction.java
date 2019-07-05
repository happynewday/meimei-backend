package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName VideoDetailBackendAction
 * @Description TODO
 * @Date 2019/7/4 15:35
 */

@Data
@ApiModel(value = "视频详情接口")
public class VideoDetailBackendAction {
    /**
     *  视频ID
     */
    @Min(1)
    @ApiModelProperty(value = "视频ID", example = "1")
    private  Integer id;
}
