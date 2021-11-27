package com.team35.restaurants.order;

// the state of the order should be changed to this after the order is delivered from the class application
public class OrderFinished extends OrderState {
    OrderFinished(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder() {
        System.out.println("This order is already finished");
    }

    void refundOrder(double cost) {
        //refund nothing
    }

    public void printState() {
        System.out.println("The order is finished");
    }

    void changeOrderState(OrderState orderState) {
        order.orderState = orderState;
    }
}
