package com.gt.drinkmall.module.material.repo;

import com.gt.drinkmall.module.material.entity.MaterialEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaterialRepo {

    Map<String, MaterialEntity> mGetByIds(List<String> ids);

}
