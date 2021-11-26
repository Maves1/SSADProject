package com.team35.restaurants.order;
// the state of the order should be changed to this after the order is delivered from the class application
public class OrderFinished extends OrderState {
    OrderFinished(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("This order is already finished");
    }
    void refundOrder() {
        //refund nothing
    }
    void changeOrderState(OrderState orderState){
        System.out.println("This order is finished");
    }
}
