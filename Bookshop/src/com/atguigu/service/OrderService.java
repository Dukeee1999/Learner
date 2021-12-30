package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;

import java.util.Map;

public interface OrderService {
    public Order createOrder(Cart cart, Integer userId);
    public Map<Integer,Order> getOrders();
    public void addOrder(Order order);
}
