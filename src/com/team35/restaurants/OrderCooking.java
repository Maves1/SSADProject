package com.team35.restaurants;

public class OrderCooking extends OrderState {
    void cancelOrder(){
        System.out.println("If you cancel now, you will get half of your order cost refunded");
    }
    void refundOrder() {
        //refund half amount
    }
    OrderState changeOrderState(){
        OrderState newState = new OrderDelivery();
        return newState;
    }
}

