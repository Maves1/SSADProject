package com.team35.restaurants.order;

public abstract class OrderState {
    Order order;
    OrderState(Order theOrder)
    {
        this.order = theOrder;
    }
    OrderState(){

    }
    abstract OrderState changeOrderState();
    abstract void cancelOrder();
    abstract void refundOrder();
}
