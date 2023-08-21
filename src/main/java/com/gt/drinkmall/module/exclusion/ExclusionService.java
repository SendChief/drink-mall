package com.gt.drinkmall.module.exclusion;

import com.gt.drinkmall.module.exclusion.entity.ExclusionType;
import com.gt.drinkmall.module.exclusion.repo.ExclusionRepo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExclusionService {

    @Resource(name = "ExclusionRepoImpl")
    private ExclusionRepo exclusionRepo;

    public boolean checkIsExclusion(String drinkId, List<String> exclusionId) {
        if (null == exclusionId || exclusionId.size() == 0) {
            return false;
        }
        //配料重复的时候
        if (exclusionId.size() != exclusionId.stream().distinct().toList().size()) {
            return true;
        }
        var data = exclusionRepo.getByMaterialIdAndExclusionIds(exclusionId, exclusionId, ExclusionType.MATERIAL_MATERIAL);
        data.addAll(exclusionRepo.getByMaterialIdAndExclusionIds(exclusionId, List.of(drinkId), ExclusionType.MATERIAL_DRINK));
        return data.size() != 0;
    }
}
