package com.team35.restaurants.order;

// the state of the order should be changed to this from the restaurant
public class OrderCooking extends OrderState {
    public OrderCooking(Order theOrder) {
        super(theOrder);
    }

    void cancelOrder(){
        System.out.println("If you cancel now, you will get half of your order cost refunded");
    }
    void refundOrder() {
        //refund half amount
    }
    void changeOrderState(OrderState orderState){
        order.orderState=orderState;
    }
    void refundOrder(double cost) {
        // Refund half of the cost
        System.out.println("Half of the order cost will be refunded: " + cost / 2);
    }
    @Override
    public void printState() {
        System.out.println("The order is being cooked right now ");
    }
}

