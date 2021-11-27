package com.team35.restaurants;

import com.team35.restaurants.order.Order;
import com.team35.restaurants.order.OrderCooking;
import com.team35.restaurants.order.OrderReceived;

import java.util.ArrayList;
import java.util.List;

public abstract class GeneralRestaurant {
    public enum Type {
        Restaurant,
        Bar,
        Cafe,
        General
    }

    protected Type type;
    protected String name;
    protected String address;
    protected String bankDetails;
    protected Menu menu;
    protected List<Order> currentOrders;

    public GeneralRestaurant(String name, String address, String bankDetails, Menu menu) {
        this.name = name;
        this.address = address;
        this.bankDetails = bankDetails;
        this.menu = menu;
        currentOrders = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public Type getType() { return type; }

    public boolean receiveOrder(Order order) {
        order.changeState(new OrderReceived(order));
        currentOrders.add(order);
        return true;
    }

}
