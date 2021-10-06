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
        int counter = 1;
        for (GeneralRestaurant s : bars) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showCafes() {
        int counter = 1;
        for (GeneralRestaurant s : cafes) {
            System.out.println(counter + "- " + s.getName());
        }
    }

    private void showRestaurants() {
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

    private void unselectType() {
        chosenType = null;
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

    private void selectRestaurant(int chosenRes) {
        switch (chosenType){
            case Bar -> chosenRestaurant=bars.get(chosenRes-1);
            case Restaurant -> chosenRestaurant=restaurants.get(chosenRes-1);
            case Cafe -> chosenRestaurant=cafes.get(chosenRes-1);
        }

    }

    private void unselectRestaurant() {
        chosenRestaurant = null;
    }

    private void showMenu(Map<String, List<Item>> menu) {
        Set set = menu.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + ":");
            List<Item> list = (List<Item>) entry.getValue();
            for (Item item : list) {
                System.out.println(" -" + item.getName());
            }
        }

    }

    private void makeOrder() {
        System.out.println("Welcome to " + chosenRestaurant.getName());
        System.out.println("Choose from the menu the category, item, and quantity.\n write finished when you are done");
        showMenu(chosenRestaurant.menu.getMenu());
        Order newOrder = new Order();
        Scanner scanner = new Scanner(System.in);
        String ItemName = "start";
        String input="start";
        while (true) {
            input=scanner.nextLine();
            if(input.equals("finished")){
                break;
            }
            String[] parts=input.split(" ");
            String category =parts[0];
            ItemName = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            Item newItem = chosenRestaurant.menu.getItem(category, ItemName);
            newOrder.addItem(newItem, quantity);
        }
        //confirming the order
        System.out.println("Your order is:");
        System.out.println("Item      Quantity");
        for (Map.Entry<Item, Integer> entry : newOrder.getItems().entrySet()) {
            Item currentItem = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(currentItem.getName()+"       "+quantity);

        }
        System.out.println("Your check= " + newOrder.getCheck());
        System.out.println("Confirm Y/N");
        String confirmation = scanner.next();
        if (confirmation.equals("Y")) {
            scanner = new Scanner(System.in);
            System.out.println("Please enter your address:");
            String address=scanner.nextLine();
            System.out.println("Order confirmed and will be delivered to "+address);
            System.out.println("Have a nice day!");
        } else {
            newOrder = null;
            System.out.println("The order was canceled, Have a nice day!");
        }

    }

    public void Start(){
        System.out.println("Welcome to our food ordering app!");
        System.out.println("Here is a list of types of places where you can order from, choose the number that you want:");
        System.out.println("1-Bars\n2-Cafes\n3-Restaurants");
        Scanner scanner = new Scanner(System.in);
        int typeAnswer = scanner.nextInt();
        selectType(typeAnswer);
        System.out.println("Choose the number of the place from the list");
        showChosenTypeRestaurants();
        scanner = new Scanner(System.in);
        int chosenRestaurantName=scanner.nextInt();
        selectRestaurant(chosenRestaurantName);
        makeOrder();
    }

}
