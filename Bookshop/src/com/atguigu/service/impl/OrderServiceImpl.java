package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import com.atguigu.utils.WebUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    private BookDao bookDao = new BookDaoImpl();
    private Map<Integer,Order> orders = new HashMap<Integer,Order>();
    @Override
    public Order createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),-1,cart.getTotalPrice(),userId);
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem>entry: cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(cartItem.getId(),cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(orderItem.getId());
            book.setSales(book.getSales()+orderItem.getCount());
            book.setStock(book.getStock() - orderItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return  order;
    }

    @Override
    public Map<Integer, Order> getOrders() {
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        Integer orderId = WebUtils.parseInt(order.getOrderId(),1);
        orders.put(orderId,order);
    }
}
