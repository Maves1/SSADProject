package com.team35.restaurants.order;
// the state of the order should be changed to this from the restaurant when it receive the order
public class OrderReceived extends OrderState{
    OrderReceived(Order theOrder) {
        super(theOrder);
    }
    OrderReceived(){

    }
    void cancelOrder(){
        System.out.println("If you cancel now, you will get fully refunded");
    }
    void refundOrder(){
        ///refund full amount
    }
    OrderState changeOrderState(){
        System.out.println("order started cooking\n");
        OrderState newState = new OrderCooking();
        return newState;
    }
}