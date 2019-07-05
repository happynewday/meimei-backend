package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName PictureCollectDetailBackendAction
 * @Description TODO
 * @Date 2019/7/3 21:12
 */

@Data
@ApiModel(value = "图集详情接口")
public class PictureCollectDetailBackendAction {
    /**
     *  图集ID
     */
    @Min(1)
    @ApiModelProperty(value = "图集ID", example = "1")
    private  Integer id;
}
