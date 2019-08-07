package com.mm.backend.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserVipInfoBackendVo
 * @Description TODO
 * @Date 2019/8/7 14:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVipInfoBackendVo {
    /**
     * 等级
     */
    @ApiModelProperty(value = "VIP等级，0为普通用户，1为VIP")
    private Integer level;
}
