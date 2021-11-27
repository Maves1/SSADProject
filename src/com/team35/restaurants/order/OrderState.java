package com.team35.restaurants.order;

public abstract class OrderState {
    Order order;
    OrderState(Order theOrder)
    {
        this.order = theOrder;
    }
    abstract void changeOrderState(OrderState orderState);
    public abstract void printState();
    abstract void cancelOrder();
    abstract void refundOrder(double cost);
}
