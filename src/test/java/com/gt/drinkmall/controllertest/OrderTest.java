package com.gt.drinkmall.controllertest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.drinkmall.controller.OrderController;
import com.gt.drinkmall.module.order.entity.OrderEntity;
import com.gt.drinkmall.module.order.entity.OrderItemVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OrderTest {

    @Autowired
    private OrderController orderController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }


    @Test
    public void testCreate() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderEntity order = new OrderEntity();
        OrderItemVo orderItem = new OrderItemVo();
        orderItem.setDrinkId("椰果奶茶");
        List<String> materialIds = new ArrayList<>();
        materialIds.add("奥利奥奶盖");
        materialIds.add("芝士奶盖");
        orderItem.setMaterialIds(materialIds);
        order.setOrderItem(List.of(orderItem));
        String strJson = objectMapper.writeValueAsString(order);
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post("/order/create")
                                .header("token", "订单")
                                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(strJson)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println("调用返回的结果：{}" + mvcResult.getResponse().getContentAsString());
    }

}
