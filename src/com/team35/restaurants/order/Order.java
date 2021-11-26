package com.team35.restaurants.order;

import com.team35.restaurants.Item;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private OrderState orderState;
    private Map<Item, Integer> items;
    private double check;
    public Order() {
        items = new HashMap<>();
    }

    public double getCheck() {
        return check;
    }



    public void addItem(Item item, int quantity) {
            items.put(item, quantity);
            check+=item.getPrice()*quantity;
    }

    public void removeItem(Item item) {
            items.remove(item);
    }

    public void changeState(OrderState orderState){
        orderState.changeOrderState(orderState);
    }
    public Map<Item, Integer> getItems() {
        return items;
    }
}
