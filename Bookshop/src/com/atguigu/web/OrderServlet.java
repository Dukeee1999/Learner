package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = user.getId();
        Order order = null;
        order = orderService.createOrder(cart, userId);
        JdbcUtils.commitAndClose();
        JdbcUtils.rollbackAndClose();
        req.getSession().setAttribute("orderId", order.getOrderId());
        orderService.addOrder(order);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
    protected void viewOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Order> orders = orderService.getOrders();
        System.out.println(orders);
        if(req.getSession().getAttribute("orders")==null) {
            req.getSession().setAttribute("orders", orders);
        }
        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }
}
