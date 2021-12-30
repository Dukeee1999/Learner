package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart = new Cart();
    @Test
    public void addItemTest(){
        cart.addItem(new CartItem(10,"lz最帅",1,new BigDecimal(100),new BigDecimal(100)));
//        cart.addItem(new CartItem(10,"lz最帅",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(12,"duke最帅",1,new BigDecimal(200),new BigDecimal(200)));
        System.out.println(cart.getTotalCount());
        System.out.println(cart.getItems());
        cart.deleteItem(10);
        System.out.println(cart.getTotalCount());
        System.out.println(cart.getItems());


    }
}