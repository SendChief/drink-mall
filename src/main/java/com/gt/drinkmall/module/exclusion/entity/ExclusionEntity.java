package com.gt.drinkmall.module.exclusion.entity;

import lombok.Data;

@Data
public class ExclusionEntity {

    private String id;

    //小料id
    private String materialId;

    //互斥id
    private String exclusionId;

    //互斥类型
    private ExclusionType exclusionType;

    public ExclusionEntity(String id, String materialId, String exclusionId, ExclusionType exclusionType) {
        this.id = id;
        this.materialId = materialId;
        this.exclusionId = exclusionId;
        this.exclusionType = exclusionType;
    }

    public ExclusionEntity() {
    }
}
