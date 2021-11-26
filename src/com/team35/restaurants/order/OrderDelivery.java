package com.team35.restaurants.order;
// the state of the order should be changed to this from the restaurant after the order is ready to be delivered
public class OrderDelivery extends OrderState {
    OrderDelivery(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("If you cancel now, you will not receive any refund");
    }
    void refundOrder() {
        //refund nothing
    }
    void changeOrderState(OrderState orderState){
        OrderState newState = orderState;
        System.out.println("Your order has been successfully delivered");
    }
}
