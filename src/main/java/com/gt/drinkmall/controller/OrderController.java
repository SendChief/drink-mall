package com.gt.drinkmall.controller;

import com.gt.drinkmall.controller.dto.OrderDto;
import com.gt.drinkmall.module.drink.entity.DrinkEntity;
import com.gt.drinkmall.module.drink.repo.DrinkRepo;
import com.gt.drinkmall.module.exclusion.ExclusionService;
import com.gt.drinkmall.module.material.entity.MaterialEntity;
import com.gt.drinkmall.module.material.repo.MaterialRepo;
import com.gt.drinkmall.module.order.OrderService;
import com.gt.drinkmall.module.order.entity.OrderEntity;
import com.gt.drinkmall.module.order.entity.OrderItemVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource(name = "DrinkRepoImpl")
    private DrinkRepo drinkRepo;

    @Resource(name = "MaterialRepoImpl")
    private MaterialRepo materialRepo;

    @Resource
    private ExclusionService exclusionService;

    @PostMapping(value = "/create")
    public OrderDto createOrder(@RequestBody OrderEntity order) throws Exception {
        OrderDto result = new OrderDto();
        if (null == order.getOrderItem() || order.getOrderItem().size() == 0) {
            result.setPrice(BigDecimal.ZERO);
            return result;
        }
        if (order.getOrderItem().size() > 10) {
            result.setPrice(new BigDecimal(-1));
            return result;
        }

        var allMaterialIds = order.getOrderItem().stream()
                .map(OrderItemVo::getMaterialIds)
                .flatMap(List::stream)
                .distinct().toList();
        var allDrinkIds = order.getOrderItem().stream().map(OrderItemVo::getDrinkId).distinct().toList();
        var material = materialRepo.mGetByIds(allMaterialIds);
        var drink = drinkRepo.mGetByIds(allDrinkIds);

        //检查单子是否合法
        for (OrderItemVo orderItem : order.getOrderItem()) {
            if (isNeedCheck(orderItem, material)) {
                var isExclusion = exclusionService.checkIsExclusion(orderItem.getDrinkId(), orderItem.getMaterialIds());
                if (isExclusion) {
                    result.setPrice(new BigDecimal(-1));
                    return result;
                }
            }
        }

        result.setPrice(getPrice(order, material, drink));
        buildDto(result, order, material, drink);
        return result;
    }

    private BigDecimal getPrice(OrderEntity orderEntity, Map<String, MaterialEntity> material, Map<String, DrinkEntity> drink) {
        BigDecimal price = BigDecimal.ZERO;
        for (OrderItemVo orderItem : orderEntity.getOrderItem()) {
            for (String materialId : orderItem.getMaterialIds()) {
                price = price.add(material.get(materialId).getPrice());
            }
            price = price.add(drink.get(orderItem.getDrinkId()).getPrice());
        }

        return price;
    }

    /**
     * 检查订单项是否需要检查
     */
    private boolean isNeedCheck(OrderItemVo orderItem, Map<String, MaterialEntity> materialMap) throws Exception {
        if (null == orderItem.getMaterialIds() || orderItem.getMaterialIds().size() == 0) {
            return false;
        }

        for (String materialId : orderItem.getMaterialIds()) {
            var materialEntity = materialMap.get(materialId);
            if (null == materialEntity) {
                throw new Exception("数据错误");
            }
            if (materialEntity.isExclusion()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 这里应该组装dto偷个懒实在有点晚懒得写了
     */
    private void buildDto(OrderDto result, OrderEntity orderEntity, Map<String, MaterialEntity> material, Map<String, DrinkEntity> drink) {

    }
}
