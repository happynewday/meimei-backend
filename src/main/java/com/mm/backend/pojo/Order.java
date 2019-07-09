package com.mm.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Double originPrice;

    private Double payPrice;

    private Short status;

    private Long createTime;

    private Long payTime;
}