package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer,CartItem> items = new HashMap<Integer,CartItem>();


    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if(item==null){
            items.put(cartItem.getId(),cartItem);
        }else{
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id){
        CartItem cartItem = items.get(id);
        if(cartItem.getCount()==1){
            items.remove(cartItem.getId());
        }else{
            cartItem.setCount(cartItem.getCount()-1);
        }
    }
    public void clear(){
        items.clear();
    }

    public void updateCount(int id,int count){
//        CartItem item = items.get(id);
//        if(item!=null){
//            item.setCount(count);
//            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
//        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem>entry: items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem>entry: items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map< Integer,CartItem> getItems() {
        return items;
    }

}
