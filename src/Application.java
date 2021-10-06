import java.util.*;

public class Application {
    private ArrayList<String> restaurantsTypes;
    private ArrayList<String> bars;
    private ArrayList<String> cafes;
    private ArrayList<String> restaurants;
    private ArrayList<Restaurant> generalRestaurant;
    private String address;
    public GeneralRestaurant.Type chosenType;
    public Restaurant chosenRestaurant;
    public Application() {
        restaurantsTypes = new ArrayList<>();
        bars = new ArrayList<>();
        cafes = new ArrayList<>();
        generalRestaurant = new ArrayList<>();
        restaurants=new ArrayList<>();
        addBars();
        addCafes();
        addRestaurants();

    }
    private void addBars() {
        bars.add("Bar 108");
        Menu barMenu = new Menu();
        barMenu.addCategory("Drinks");
        barMenu.addItem("Drinks", new Item("Beer", 150.0));
        barMenu.addItem("Drinks", new Item("Otvertka", 999.0));
        barMenu.addCategory("Food");
        barMenu.addItem("Food", new Item("Burger", 300.0));
        generalRestaurant.add(new Restaurant("Bar 108", "", "", barMenu));// add some info for the bar
    }

    private void addCafes() {
        cafes.add("Starbucks");
        Menu cafeMenu = new Menu();
        cafeMenu.addCategory("Drinks");
        cafeMenu.addItem("Drinks", new Item("coffee", 100.0));
        cafeMenu.addItem("Drinks", new Item("tea", 50.0));
        generalRestaurant.add(new Restaurant("Starbucks", "", "", cafeMenu));
    }

    private void addRestaurants() {
        restaurants.add("Mcdonalds");
        Menu restaurantMenu = new Menu();
        restaurantMenu.addCategory("Drinks");
        restaurantMenu.addItem("Drinks", new Item("Pepsi", 50.0));
        restaurantMenu.addItem("Drinks", new Item("fanta", 50.0));
        restaurantMenu.addCategory("Food");
        restaurantMenu.addItem("Food", new Item("Burger", 300.0));
        generalRestaurant.add(new Restaurant("Mcdonalds", "", "", restaurantMenu));
    }

    private void showBars() {
        int counter = 0;
        for (String s : bars) {
            System.out.println(counter + "- " + s);
        }
    }

    private void showCafes() {
        int counter = 0;
        for (String s : cafes) {
            System.out.println(counter + "- " + s);
        }
    }

    private void showRestaurants() {
        int counter = 0;
        for (String s : restaurants) {
            System.out.println(counter + "- " + s);
        }
    }




    public void showTypes() {
        int counter = 0;
        for (String s : restaurantsTypes) {
            System.out.println(counter + "- " + s);
        }
    }


    public void selectType(GeneralRestaurant.Type type) {
        switch (type) {
            case Bar:
                chosenType = GeneralRestaurant.Type.Bar;
                break;
            case Cafe:
                chosenType = GeneralRestaurant.Type.Cafe;
                break;
            case Restaurant:
                chosenType = GeneralRestaurant.Type.Restaurant;
                break;
            default:
                System.out.println("Please choose one of the given restaurant types");
                break;
        }
    }

    public void unselectType() {
        chosenType = null;
    }

    public void showGeneralRestaurants() {
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

    public void selectRes(String chosenRes) {
        for (Restaurant restaurant : generalRestaurant) {
            if (restaurant.name == chosenRes) {
                chosenRestaurant = restaurant;
                break;
            }
        }
    }

    public void unselectRes() {
        chosenRestaurant = null;
    }

    public void showMenu(Map<String, List<Item>> menu) {
        Set set = menu.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + ":");
            List<Item> list = (List<Item>) entry.getValue();
            for (Item item : list) {
                System.out.println(" -" + item);
            }
        }

    }

    public void makeOrder() {
        System.out.println("Welcome to restaurant " + chosenRestaurant.name);
        System.out.println("Choose from the menu the category, item, and quantity.\n write finished when you are done");
        showMenu(chosenRestaurant.menu.getMenu());
        Order newOrder = new Order();
        Scanner scanner = new Scanner(System.in);
        String ItemName="start";
        while (!ItemName.equals("finished"))
        {
            String category = scanner.next();
            ItemName = scanner.next();
            int quantity=scanner.nextInt();
            Item newItem=chosenRestaurant.menu.getItem(category,ItemName);
            newOrder.addItem(newItem,quantity);
        }
        //confirming the order
        System.out.println("Your order is:");
        //printing the order
        System.out.println("Confirm Y/N");
        String confirmation=scanner.next();
        if(confirmation.equals("Y"))
        {
            System.out.println("Your check= "+newOrder.getCheck());
        }
        else
        {
            newOrder=null;
            System.out.println("The order was canceled, Have a nice day!");
        }
        
    }
}
