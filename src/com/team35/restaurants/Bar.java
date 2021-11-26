package com.team35.restaurants;

import com.team35.restaurants.order.Order;

public class Bar extends GeneralRestaurant {

    public Bar(String name, String address, String bankDetails, Menu menu) {
        super(name, address, bankDetails, menu);
        this.type = Type.Bar;
    }

    @Override
    public boolean receiveOrder(Order order) {
        if (Application.checkIfAdult()) {
            super.receiveOrder(order);
            return true;
        } else {
            return false;
        }
    }

}
