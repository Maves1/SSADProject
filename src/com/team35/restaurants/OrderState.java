package com.team35.restaurants;

public class OrderState {
    OrderState(){
    }
    OrderState(OrderState status){
    }
    OrderState changeOrderState(){
        OrderState temp = new OrderState();
        return temp;
    }
    void cancelOrder(){
    }
    void refundOrder() {
    }
}
