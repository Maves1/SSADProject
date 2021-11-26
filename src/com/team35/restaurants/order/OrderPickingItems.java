package com.team35.restaurants.order;
// the state of the order should be changed to this from the class application after the order is created
public class OrderPickingItems extends OrderState{
    OrderPickingItems(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("The order is canceled, have a nice day!");
    }
    void refundOrder() {
        //refund nothing
    }
    void changeOrderState(OrderState orderState){

        System.out.println("The order has been sent to the restaurant");
    }
}
