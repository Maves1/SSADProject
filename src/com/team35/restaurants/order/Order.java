package com.team35.restaurants.order;

import com.team35.restaurants.Item;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private final Map<Item, Integer> items;
    public OrderState orderState;
    private double check;

    public Order() {
        items = new HashMap<>();
        orderState = new OrderPickingItems(this);
    }

    public double getCheck() {
        return check;
    }

    public void addItem(Item item, int quantity) {
        items.put(item, quantity);
        check += item.getPrice() * quantity;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void changeState(OrderState orderState) {
        orderState.changeOrderState(orderState);
    }

    public void cancelOrder() {
        orderState.cancelOrder();
    }

    public void refundOrder() {
        orderState.refundOrder(check);
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}
