package com.team35.restaurants.order;
// the state of the order should be changed to this from the restaurant when it receive the order
public class OrderReceived extends OrderState{
    public OrderReceived(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("If you cancel now, you will get fully refunded");
    }
    void refundOrder(double cost) {
        // Refund full amount
        System.out.println("The full cost of the order will be refunded: " + cost);
    }

    public void printState(){
        System.out.println("Now the order is in the state of being received from the restaurant");
    }
    void changeOrderState(OrderState orderState){
        order.orderState=orderState;
    }
}