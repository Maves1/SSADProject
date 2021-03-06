package com.team35.application;

import com.team35.notifications.NotificationDecorator;
import com.team35.notifications.Notifier;
import com.team35.restaurants.GeneralRestaurant;
import com.team35.restaurants.Item;
import com.team35.restaurants.order.Order;

import java.util.*;

/*
    Many things in this class are added just to test the functionality.
    If it was a real project, most of this would be totally different.
 */
public class Application {
    Database db;

    private ArrayList<GeneralRestaurant> generalRestaurants;
    public GeneralRestaurant.Type chosenType;
    public GeneralRestaurant chosenRestaurant;

    static Scanner scanner = new Scanner(System.in);

    public Application() {
        db = new Database();
        generalRestaurants = new ArrayList<>();
        initializeAllRestaurants();
    }

    private void initializeAllRestaurants() {
        generalRestaurants = db.getRestaurantList(GeneralRestaurant.Type.General);
    }

    public static boolean checkIfAdult() {
        System.out.println("You must confirm that you are older than 18\n1 - Yes\n2 - No");
        int userInput = scanner.nextInt();
        while (userInput != 0 && userInput != 1) {
            System.out.println("Please enter a correct number!");
            System.out.println("Are you over 18?\n1 - Yes\n2 0 No");
            userInput = scanner.nextInt();
        }
        scanner.nextLine();
        if (userInput == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void showBars() {
        ArrayList<GeneralRestaurant> bars = db.getRestaurantList(GeneralRestaurant.Type.Bar);

        int counter = 1;
        for (GeneralRestaurant s : bars) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showCafes() {
        ArrayList<GeneralRestaurant> cafes = db.getRestaurantList(GeneralRestaurant.Type.Cafe);

        int counter = 1;
        for (GeneralRestaurant s : cafes) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showRestaurants() {
        ArrayList<GeneralRestaurant> restaurants = db.getRestaurantList(GeneralRestaurant.Type.Restaurant);

        int counter = 1;
        for (GeneralRestaurant s : restaurants) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void selectType(int type) {
        switch (type) {
            case 1:
                chosenType = GeneralRestaurant.Type.Bar;
                break;
            case 2:
                chosenType = GeneralRestaurant.Type.Cafe;
                break;
            case 3:
                chosenType = GeneralRestaurant.Type.Restaurant;
                break;
            default:
                System.out.println("Please choose one of the given restaurant types");
                break;
        }
    }

    private void showChosenTypeRestaurants() {
        switch (chosenType) {
            case Bar:
                showBars();
                break;
            case Cafe:
                showCafes();
                break;
            case Restaurant:
                showRestaurants();
                break;
            default:
                System.out.println("Please choose one of the given restaurants");
                break;
        }
    }

    // This method is hardcoded
    private void selectRestaurant(int chosenRes) {
        switch (chosenType) {
            case Bar -> chosenRestaurant = generalRestaurants.get(0);
            case Restaurant -> chosenRestaurant = generalRestaurants.get(2);
            case Cafe -> chosenRestaurant = generalRestaurants.get(1);
        }

    }

    private void showMenu(Map<String, List<Item>> menu) {
        for (Map.Entry<String, List<Item>> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Item item : entry.getValue()) {
                System.out.println("-" + item.getName() + " $" + item.getPrice());
            }
        }

    }

    private void makeOrder() {
        System.out.println("Welcome to " + chosenRestaurant.getName());
        System.out.println("Write the category, item, and quantity.\n write finished when you are done");
        showMenu(chosenRestaurant.getMenu().getMenu());
        final Order newOrder = new Order();
        String itemName = "start";
        String input = "start";
        scanner.nextLine();
        while (true) {
            input = scanner.nextLine().strip();
            if (input.equals("finished")) {
                break;
            }
            String[] parts = input.split(" ");
            String category = parts[0];
            itemName = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            Item newItem = chosenRestaurant.getMenu().getItem(category, itemName);
            newOrder.addItem(newItem, quantity);
        }
        //confirming the order
        System.out.println("Your order is:");
        System.out.println("restaurants.Item      Quantity");
        for (Map.Entry<Item, Integer> entry : newOrder.getItems().entrySet()) {
            Item currentItem = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(currentItem.getName() + "       " + quantity);

        }
        System.out.println("Your check= " + newOrder.getCheck());
        System.out.println("Confirm Y/N");
        String confirmation = scanner.next();
        scanner.nextLine();
        if (confirmation.equals("Y") && chosenRestaurant.receiveOrder(newOrder)) {
            System.out.println("Please enter your address:");
            String address = scanner.nextLine();
            System.out.println("Would you like to get the check via email? SMS? Telegram? (Y/N) (ex: YNY)");
            String notificationOptions = scanner.nextLine();
            int mask = 0;
            for (int i = 0; i < 3; i++) {
                if (notificationOptions.charAt(i) == 'Y') {
                    mask += (1 << i);
                }
            }
            // New
            System.out.println("Please enter your email, or a \"#\" (in case you don't want to use it) in the next line");
            String email = scanner.nextLine();
            System.out.println("Please enter your phone number, or a \"#\" (in case you don't want to use it) in the next line");
            String phone = scanner.nextLine();
            System.out.println("Please enter your telegram alias, or a \"#\" (in case you don't want to use it) in the next line");
            String telegramAlias = scanner.nextLine();
            Notifier notifier = new Notifier(email, phone, telegramAlias);
            NotificationDecorator multiplePlatformsNotifications = new NotificationDecorator(mask, notifier);
            multiplePlatformsNotifications.sendCheck();

            // Testing
            System.out.println("restaurants.Order confirmed and will be delivered to " + address);
            System.out.println("Have a nice day!");

            Thread orderStatusUpdateThread = new Thread() {
                public void run() {
                    long orderStatusSwitchBoundary = 8;
                    long counter = 0;
                    int currIndex = 0;
                    List<OrderState> states = new ArrayList<>();
                    states.add(new OrderCooking(newOrder));
                    states.add(new OrderDelivery(newOrder));
                    states.add(new OrderFinished(newOrder));

                    while (counter < orderStatusSwitchBoundary) {
                        counter++;
                        if (counter == orderStatusSwitchBoundary) {
                            newOrder.changeState(states.get(currIndex));
                            counter = 0;
                            currIndex++;
                        }
                        if (currIndex > 2) {
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            orderStatusUpdateThread.start();

            System.out.println("To cancel your order, type \"cancel\"");
            input = scanner.next().strip();
            if (input.equals("cancel")) {
                orderStatusUpdateThread.stop();
                newOrder.cancelOrder();
                System.out.println("Are you sure? (Y/N)");
                input = scanner.next();
                if (input.toLowerCase(Locale.ROOT).equals("y")) {
                    newOrder.refundOrder();
                }
            }

        } else {
            newOrder.cancelOrder();
        }

    }

    public void start() {
        System.out.println("Welcome to our food ordering app!");
        System.out.println("Here is a list of types of places where you can order from, choose the number that you want:");
        System.out.println("1-Bars\n2-Cafes\n3-Restaurants");
        int typeAnswer = scanner.nextInt();
        selectType(typeAnswer);
        System.out.println("Choose the number of the place from the list");
        showChosenTypeRestaurants();
        int chosenRestaurantName = scanner.nextInt();
        selectRestaurant(chosenRestaurantName);
        makeOrder();
    }

}
