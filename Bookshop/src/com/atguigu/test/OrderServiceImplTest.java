package com.atguigu.test;

import com.atguigu.pojo.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    private Map<Integer, Order> orders = new HashMap<Integer,Order>();
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void getOrders() {

    }

    @Test
    public void addOrder() {
        orderService.addOrder(new Order("1",new Date(),-1,new BigDecimal(100),10));
        orderService.addOrder(new Order("2",new Date(),-1,new BigDecimal(200),11));
        System.out.println(orderService.getOrders());
    }
}