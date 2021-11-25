package com.team35.restaurants;

import java.util.HashMap;
import java.util.Map;

public class Order {
    enum Status {
        PickingItems,
        Cooking,
        Delivery,
        Finished
    }
    private OrderState orderState;
    private Map<Item, Integer> items;
    private double check;
    private Status orderStatus;
    public Order() {
        items = new HashMap<>();
        orderStatus = Status.PickingItems;
    }

    public double getCheck() {
        return check;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addItem(Item item, int quantity) {
        if (orderStatus == Status.PickingItems) {
            items.put(item, quantity);
            check+=item.getPrice()*quantity;
        }
    }

    public void removeItem(Item item) {
        if (orderStatus == Status.PickingItems) {
            items.remove(item);
        }
    }

    public void changeOrderState(){
        orderState.changeOrderState();
    }
    public void cancelOrder(){
        orderState.cancelOrder();
    }
    public void refundOrder(){
        orderState.refundOrder();
    }
    public Map<Item, Integer> getItems() {
        return items;
    }
}
