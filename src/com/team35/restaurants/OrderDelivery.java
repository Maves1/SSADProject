package com.team35.restaurants;

public class OrderDelivery extends OrderState {
    void cancelOrder(){
        System.out.println("If you cancel now, you will not receive any refund");
    }
    void refundOrder() {
        //refund nothing
    }
    OrderState changeOrderState(){
        OrderState newState = new OrderState();
        System.out.println("Your order has been successfully delivered");
        return newState;
    }
}
