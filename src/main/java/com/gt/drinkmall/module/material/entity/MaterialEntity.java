package com.gt.drinkmall.module.material.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialEntity {

    private String id;

    private String materialName;

    private BigDecimal price;

    private boolean isExclusion;

    public MaterialEntity(String id, String materialName, BigDecimal price, boolean isExclusion) {
        this.id = id;
        this.materialName = materialName;
        this.price = price;
        this.isExclusion = isExclusion;
    }

    public MaterialEntity() {
    }
}
