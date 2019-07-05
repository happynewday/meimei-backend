package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName FavorateVideoBackendAction
 * @Description TODO
 * @Date 2019/7/3 22:05
 */

@Data
@ApiModel(value = "收藏视频接口")
public class FavorateVideoBackendAction {
    /**
     *  视频ID
     */
    @Min(1)
    @ApiModelProperty(value = "视频ID", example = "1")
    private  Integer id;
}
