package com.gt.drinkmall.module.drink.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 这里的materialIds数据库中是没有的
 */
@Data
public class DrinkEntity {

    private String id;

    private String drinkName;

    private BigDecimal price;

    public DrinkEntity(String id, String drinkName, BigDecimal price) {
        this.id = id;
        this.drinkName = drinkName;
        this.price = price;
    }

    public DrinkEntity() {
    }
}
