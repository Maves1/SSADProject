package com.team35.restaurants.order;

// the state of the order should be changed to this from the restaurant after the order is ready to be delivered
public class OrderDelivery extends OrderState {
    OrderDelivery(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder() {
        System.out.println("If you cancel now, you will not receive any refund");
    }

    void refundOrder(double cost) {
        // Refund nothing
        System.out.println("Nothing will be refunded");
    }

    public void printState() {
        System.out.println("Now the order is in the state of delivering");
    }

    void changeOrderState(OrderState orderState) {
        order.orderState = orderState;
    }
}
