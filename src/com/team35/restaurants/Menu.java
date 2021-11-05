package com.team35.restaurants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, List<Item>> menu;

    public Menu() {
        menu = new HashMap<>();
    }

    public void addCategory(String category) {
        menu.put(category, new ArrayList<>());
    }

    public void removeCategory(String category) {
        menu.remove(category);
    }

    public boolean addItem(String category, Item item) {
        if (menu.containsKey(category)) {
            menu.get(category).add(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeItem(String category, Item item) {
        if (menu.containsKey(category) && menu.get(category).contains(item)) {
            return menu.get(category).remove(item);
        } else {
            return false;
        }
    }

    public Map<String, List<Item>> getMenu() {
        return menu;
    }

    public Item getItem(String category, String itemName) {
        List<Item> items = menu.get(category);
        for (Item i : items) {
            if (itemName.equals(i.getName())) {
                return i;
            }
        }
        return null;
    }
}
