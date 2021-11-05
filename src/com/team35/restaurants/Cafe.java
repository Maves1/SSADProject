package com.team35.restaurants;

public class Cafe extends GeneralRestaurant {
    public Cafe(String name, String address, String bankDetails, Menu menu) {
        super(name, address, bankDetails, menu);
        this.type = Type.Cafe;
    }
}
