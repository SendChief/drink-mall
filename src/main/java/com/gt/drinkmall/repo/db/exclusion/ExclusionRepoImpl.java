package com.gt.drinkmall.repo.db.exclusion;

import com.gt.drinkmall.module.exclusion.entity.ExclusionEntity;
import com.gt.drinkmall.module.exclusion.entity.ExclusionType;
import com.gt.drinkmall.module.exclusion.repo.ExclusionRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * mock的数据，模拟数据库链接
 * id 应该用uuid替代，这里简单处理
 */
@Component("ExclusionRepoImpl")
public class ExclusionRepoImpl implements ExclusionRepo {

    private static List<ExclusionEntity> mockData = new ArrayList<>();

    static {
        mockData.add(new ExclusionEntity("1", "奥利奥奶盖", "芝士奶盖", ExclusionType.MATERIAL_MATERIAL));
        mockData.add(new ExclusionEntity("2", "红豆", "美式咖啡", ExclusionType.MATERIAL_DRINK));
        mockData.add(new ExclusionEntity("3", "芋圆", "美式咖啡", ExclusionType.MATERIAL_DRINK));
        mockData.add(new ExclusionEntity("4", "红豆", "拿铁咖啡", ExclusionType.MATERIAL_DRINK));
        mockData.add(new ExclusionEntity("5", "芋圆", "拿铁咖啡", ExclusionType.MATERIAL_DRINK));
    }


    @Override
    public List<ExclusionEntity> getByMaterialIdAndExclusionIds(List<String> materialId, List<String> exclusionIds, ExclusionType type) {
        if (exclusionIds == null || exclusionIds.size() == 0) {
            return Collections.emptyList();
        }

        List<ExclusionEntity> result = new ArrayList<>();
        for (ExclusionEntity mockDatum : mockData) {
            if (materialId.contains(mockDatum.getMaterialId()) && exclusionIds.contains(mockDatum.getExclusionId()) && mockDatum.getExclusionType().equals(type)) {
                result.add(mockDatum);
            }
        }
        return result;
    }
}
