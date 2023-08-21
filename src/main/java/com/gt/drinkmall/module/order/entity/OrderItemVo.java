package com.gt.drinkmall.module.order.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderItemVo {

    private String drinkId;

    private List<String> materialIds;

}
