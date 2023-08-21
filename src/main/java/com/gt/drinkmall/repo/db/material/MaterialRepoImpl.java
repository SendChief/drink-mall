package com.gt.drinkmall.repo.db.material;

import com.gt.drinkmall.module.drink.entity.DrinkEntity;
import com.gt.drinkmall.module.exclusion.entity.ExclusionEntity;
import com.gt.drinkmall.module.material.entity.MaterialEntity;
import com.gt.drinkmall.module.material.repo.MaterialRepo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * mock的数据，模拟数据库链接
 * id 应该用uuid替代，这里简单处理
 */
@Component("MaterialRepoImpl")
public class MaterialRepoImpl implements MaterialRepo {

    private static List<MaterialEntity> mockData = new ArrayList<>();

    static {
        mockData.add(new MaterialEntity("芋圆", "芋圆", new BigDecimal(2), true));
        mockData.add(new MaterialEntity("红豆", "红豆", new BigDecimal(2), true));
        mockData.add(new MaterialEntity("奥利奥奶盖", "奥利奥奶盖", new BigDecimal(4), true));
        mockData.add(new MaterialEntity("芝士奶盖", "芝士奶盖", new BigDecimal(5), false));
    }


    @Override
    public Map<String, MaterialEntity> mGetByIds(List<String> ids) {
        if (ids == null || ids.size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, MaterialEntity> result = new HashMap<>();
        for (MaterialEntity mockDatum : mockData) {
            if (ids.contains(mockDatum.getId())) {
                result.put(mockDatum.getId(), mockDatum);
            }
        }

        return result;
    }
}
