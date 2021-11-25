package com.team35.restaurants;

public class OrderReceived extends OrderState{
    void cancelOrder(){
        System.out.println("If you cancel now, you will get fully refunded");
    }
    void refundOrder(){
        ///refund full amount
    }
    OrderState changeOrderState(){
        OrderState newState = new OrderCooking();
        return newState;
    }
}