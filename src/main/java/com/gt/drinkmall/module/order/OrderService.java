package com.gt.drinkmall.module.order;

import com.gt.drinkmall.module.order.entity.OrderEntity;
import com.gt.drinkmall.module.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public void create(OrderEntity order) {

    }

}
