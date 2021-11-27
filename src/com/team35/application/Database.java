package com.team35.application;

import com.team35.restaurants.GeneralRestaurant;
import com.team35.restaurants.Item;
import com.team35.restaurants.Menu;
import com.team35.restaurants.RestaurantFactory;

import java.util.ArrayList;

/*
    Many things in this class are added just to test the functionality.
    If it was a real project, most of this would be totally different.
 */
public class Database {
    RestaurantFactory restaurantFactory;
    ArrayList<GeneralRestaurant> restaurants;

    public Database() {
        restaurantFactory = new RestaurantFactory();
        restaurants = new ArrayList<>();

        Menu barMenu = new Menu();
        barMenu.addCategory("Drinks");
        barMenu.addItem("Drinks", new Item("Beer", 150.0));
        barMenu.addItem("Drinks", new Item("Otvertka", 999.0));
        barMenu.addCategory("Food");
        barMenu.addItem("Food", new Item("Burger", 300.0));

        GeneralRestaurant bar = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Bar, barMenu,
                "restaurants.Bar 108", "Sportivnaya", "5536");
        restaurants.add(bar);

        Menu cafeMenu = new Menu();
        cafeMenu.addCategory("Drinks");
        cafeMenu.addItem("Drinks", new Item("coffee", 100.0));
        cafeMenu.addItem("Drinks", new Item("tea", 50.0));
        GeneralRestaurant cafe = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Cafe, cafeMenu,
                "Starbucks", "Kazan", "5536");
        restaurants.add(cafe);

        Menu restaurantMenu = new Menu();
        restaurantMenu.addCategory("Drinks");
        restaurantMenu.addItem("Drinks", new Item("Pepsi", 50.0));
        restaurantMenu.addItem("Drinks", new Item("Fanta", 50.0));
        restaurantMenu.addCategory("Food");
        restaurantMenu.addItem("Food", new Item("Burger", 300.0));
        GeneralRestaurant restaurant = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Restaurant,
                restaurantMenu, "McDonald's", "Kazan", "5536");
        restaurants.add(restaurant);
    }

    public ArrayList<GeneralRestaurant> getRestaurantList(GeneralRestaurant.Type filter) {
        ArrayList<GeneralRestaurant> list = new ArrayList<>();

        if (filter != GeneralRestaurant.Type.General) {
            for (GeneralRestaurant restaurant : restaurants) {
                if (restaurant.getType() == filter) {
                    list.add(restaurant);
                }
            }
            return list;
        } else {
            return restaurants;
        }
    }
}
