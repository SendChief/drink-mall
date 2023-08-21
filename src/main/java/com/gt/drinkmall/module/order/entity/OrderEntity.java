package com.gt.drinkmall.module.order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderEntity {

    private String id;

    private String orderName;

    private List<OrderItemVo> orderItem;

    private BigDecimal price;

}
