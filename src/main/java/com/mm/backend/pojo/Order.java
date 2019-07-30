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

    public interface status
    {
        int CANCELLED = -10;
        //创建未支付
        int INITIAL = 0;
        //已支付
        int PAYED = 10;
        //已完成
        int CLOSED = 20;
    }
}