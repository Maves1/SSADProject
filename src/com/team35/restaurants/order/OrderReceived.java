package com.team35.restaurants.order;

// the state of the order should be changed to this from the restaurant when it receive the order
public class OrderReceived extends OrderState {
    OrderReceived(Order theOrder) {
        super(theOrder);
    }

    OrderReceived() {

    }

    void cancelOrder() {
        System.out.println("If you cancel now, you will get a full refund");
    }

    void refundOrder(double cost) {
        // Refund full amount
        System.out.println("The full cost of the order will be refunded: " + cost);
    }

    OrderState changeOrderState() {
        System.out.println("order started cooking\n");
        OrderState newState = new OrderCooking();
        return newState;
    }
}