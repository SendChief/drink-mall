package com.gt.drinkmall.repo.db.drink;

import com.gt.drinkmall.module.drink.entity.DrinkEntity;
import com.gt.drinkmall.module.drink.repo.DrinkRepo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * mock的数据，模拟数据库链接
 * id 应该用uuid替代，这里简单处理
 */
@Component("DrinkRepoImpl")
public class DrinkRepoImpl implements DrinkRepo {

    private static List<DrinkEntity> mockData = new ArrayList<>();

    static {
        mockData.add(new DrinkEntity("椰果奶茶", "椰果奶茶", new BigDecimal(10)));
        mockData.add(new DrinkEntity("西米奶茶", "西米奶茶", new BigDecimal(10)));
        mockData.add(new DrinkEntity("蜂蜜奶茶", "蜂蜜奶茶", new BigDecimal(12)));
        mockData.add(new DrinkEntity("杏仁奶茶", "杏仁奶茶", new BigDecimal(14)));
        mockData.add(new DrinkEntity("美式咖啡", "美式咖啡", new BigDecimal(11)));
        mockData.add(new DrinkEntity("拿铁咖啡", "拿铁咖啡", new BigDecimal(12)));
    }


    @Override
    public Map<String, DrinkEntity> mGetByIds(List<String> drinkIdList) {
        if (drinkIdList == null || drinkIdList.size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, DrinkEntity> result = new HashMap<>();
        for (DrinkEntity mockDatum : mockData) {
            if (drinkIdList.contains(mockDatum.getId())) {
                result.put(mockDatum.getId(), mockDatum);
            }
        }

        return result;
    }
}
