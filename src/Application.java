import java.util.*;

public class Application {
    RestaurantFactory restaurantFactory;

    private ArrayList<GeneralRestaurant> bars;
    private ArrayList<GeneralRestaurant> cafes;
    private ArrayList<GeneralRestaurant> restaurants;
    private ArrayList<GeneralRestaurant> generalRestaurants;
    public GeneralRestaurant.Type chosenType;
    public GeneralRestaurant chosenRestaurant;

    public Application() {
        restaurantFactory = new RestaurantFactory();
        bars = new ArrayList<>();
        cafes = new ArrayList<>();
        generalRestaurants = new ArrayList<>();
        restaurants = new ArrayList<>();
        initializeAllRestaurants();
    }

    private void initializeAllRestaurants() {

        Menu barMenu = new Menu();
        barMenu.addCategory("Drinks");
        barMenu.addItem("Drinks", new Item("Beer", 150.0));
        barMenu.addItem("Drinks", new Item("Otvertka", 999.0));
        barMenu.addCategory("Food");
        barMenu.addItem("Food", new Item("Burger", 300.0));

        GeneralRestaurant bar = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Bar, barMenu,
                "Bar 108", "Sportivnaya", "5536");
        generalRestaurants.add(bar);
        bars.add(bar);

        Menu cafeMenu = new Menu();
        cafeMenu.addCategory("Drinks");
        cafeMenu.addItem("Drinks", new Item("coffee", 100.0));
        cafeMenu.addItem("Drinks", new Item("tea", 50.0));
        GeneralRestaurant cafe = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Cafe, cafeMenu,
                "Starbucks", "Kazan", "5536");
        generalRestaurants.add(cafe);
        cafes.add(cafe);

        Menu restaurantMenu = new Menu();
        restaurantMenu.addCategory("Drinks");
        restaurantMenu.addItem("Drinks", new Item("Pepsi", 50.0));
        restaurantMenu.addItem("Drinks", new Item("Fanta", 50.0));
        restaurantMenu.addCategory("Food");
        restaurantMenu.addItem("Food", new Item("Burger", 300.0));
        GeneralRestaurant restaurant = restaurantFactory.createRestaurant(GeneralRestaurant.Type.Restaurant,
                restaurantMenu, "McDonald's", "Kazan", "5536");
        generalRestaurants.add(restaurant);
        restaurants.add(restaurant);

    }

    private void showBars() {
        int counter = 0;
        for (GeneralRestaurant s : bars) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showCafes() {
        int counter = 0;
        for (GeneralRestaurant s : cafes) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showRestaurants() {
        int counter = 0;
        for (GeneralRestaurant s : restaurants) {
            System.out.println(counter + "- " + s.getName());
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

    public void showChosenTypeRestaurants() {
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

    public void selectRestaurant(String chosenRes) {
        for (GeneralRestaurant restaurant : generalRestaurants) {
            if (restaurant.name == chosenRes) {
                chosenRestaurant = restaurant;
                break;
            }
        }
    }

    public void unselectRestaurant() {
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
        System.out.println("Welcome to restaurant " + chosenRestaurant.getName());
        System.out.println("Choose from the menu the category, item, and quantity.\n write finished when you are done");
        showMenu(chosenRestaurant.menu.getMenu());
        Order newOrder = new Order();
        Scanner scanner = new Scanner(System.in);
        String ItemName = "start";
        while (!ItemName.equals("finished")) {
            String category = scanner.next();
            ItemName = scanner.next();
            int quantity = scanner.nextInt();
            Item newItem = chosenRestaurant.menu.getItem(category, ItemName);
            newOrder.addItem(newItem, quantity);
        }
        //confirming the order
        System.out.println("Your order is:");
        //printing the order
        System.out.println("Confirm Y/N");
        String confirmation = scanner.next();
        if (confirmation.equals("Y")) {
            System.out.println("Your check= " + newOrder.getCheck());
        } else {
            newOrder = null;
            System.out.println("The order was canceled, Have a nice day!");
        }

    }
}
