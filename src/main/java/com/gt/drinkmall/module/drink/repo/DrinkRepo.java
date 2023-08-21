package com.gt.drinkmall.module.drink.repo;

import com.gt.drinkmall.module.drink.entity.DrinkEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DrinkRepo {

    Map<String, DrinkEntity> mGetByIds(List<String> drinkIdList);

}
