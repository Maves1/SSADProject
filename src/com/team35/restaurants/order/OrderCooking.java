package com.team35.restaurants.order;

// the state of the order should be changed to this from the restaurant
public class OrderCooking extends OrderState {
    OrderCooking(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("If you cancel now, you will get half of your order cost refunded");
    }
    void refundOrder() {
        //refund half amount
    }
    void changeOrderState(OrderState orderState){
        OrderState newState = orderState;
    }
}

