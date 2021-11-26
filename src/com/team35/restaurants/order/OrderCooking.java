package com.team35.restaurants.order;

// the state of the order should be changed to this from the restaurant
public class OrderCooking extends OrderState {
    OrderCooking(Order theOrder) {
        super(theOrder);
    }
    OrderCooking(){

    }
    void cancelOrder(){
        System.out.println("If you cancel now, you will get half of your order cost refunded");
    }
    void refundOrder() {
        //refund half amount
    }
    OrderState changeOrderState(){
        System.out.println("Order is getting delivered to you now");
        OrderState newState = new OrderDelivery();
        return newState;
    }
}

