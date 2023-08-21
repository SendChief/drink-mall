package com.gt.drinkmall.module.exclusion.repo;

import com.gt.drinkmall.module.exclusion.entity.ExclusionEntity;
import com.gt.drinkmall.module.exclusion.entity.ExclusionType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExclusionRepo{

    List<ExclusionEntity> getByMaterialIdAndExclusionIds(List<String> materialId, List<String> exclusionIds, ExclusionType type);

}
