package com.mm.backend.action;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName PictureListBackendAction
 * @Description TODO
 * @Date 2019/7/3 20:46
 */

@Data
@ApiModel(value = "图集列表接口")
public class PictureListBackendAction {
    /**
     *  演员ID
     */
    @ApiModelProperty(value = "演员ID", example = "1")
    private  Integer actorId;

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
