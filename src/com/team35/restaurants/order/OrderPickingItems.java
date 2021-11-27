package com.team35.restaurants.order;
// the state of the order should be changed to this from the class application after the order is created
public class OrderPickingItems extends OrderState{
    public OrderPickingItems(Order theOrder) {
        super(theOrder);
    }
    public void printState(){
        System.out.println("Now the order is in the state of piking the items");
    }

    void cancelOrder(){
        System.out.println("The order is canceled, have a nice day!");
    }
    void refundOrder(double cost) {
        // There is nothing to refund
    }
    void changeOrderState(OrderState orderState){
        order.orderState=orderState;
    }
}
