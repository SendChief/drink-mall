package com.gt.drinkmall.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {

    private String orderId;

    private BigDecimal price;

    private List<DrinkDto> drinkDtoList;

}
