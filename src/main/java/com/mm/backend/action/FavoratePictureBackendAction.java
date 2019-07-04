package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName FavoratePictureBackendAction
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 21:22
 */

@Data
@ApiModel(value = "收藏图集接口")
public class FavoratePictureBackendAction {
    /**
     *  图集ID
     */
    @Min(1)
    @ApiModelProperty(value = "图集ID", example = "1")
    private  Integer id;
}
