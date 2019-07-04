package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PictureCollectDetailBackendVo
 * @Description TODO
 * @Author XUJIAN
 * @Date 2019/7/3 21:07
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PictureCollectDetailBackendVo {
    /**
     * 图集ID
     */
    @ApiModelProperty(value = "图集ID")
    private Integer id;

    /**
     * 演员
     */
    @ApiModelProperty(value = "演员")
    private String actor;

    /**
     * 图片数量
     */
    @ApiModelProperty(value = "图片数量")
    private Integer number;

    /**
     * 图片列表
     */
    @ApiModelProperty(value = "图片列表")
    private List<String> pictures;
}
