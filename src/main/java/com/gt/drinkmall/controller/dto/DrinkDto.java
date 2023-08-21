package com.gt.drinkmall.controller.dto;

import com.gt.drinkmall.module.material.entity.MaterialEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DrinkDto {

    private String id;

    private String drinkName;

    private BigDecimal price;

    //这个地方应该定一个dto，偷个懒
    private List<MaterialEntity> materials;

}
