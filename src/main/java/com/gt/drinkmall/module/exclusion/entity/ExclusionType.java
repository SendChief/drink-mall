package com.gt.drinkmall.module.exclusion.entity;

public enum ExclusionType {
    MATERIAL_MATERIAL(1, "配料互斥"),
    MATERIAL_DRINK(2, "配料，饮品互斥")
    ;

    private int id;
    private String desc;

    ExclusionType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
