
import java.util.*;

enum Types{
    Bar,
    Cafe,
    normalRestaurant
}

public class Application {
    private ArrayList<String> restaurantsTypes=new ArrayList<>();
    private ArrayList<String> bars=new ArrayList<>();
    private ArrayList<String> cafes=new ArrayList<>();
    private ArrayList<String> normalRestaurants =new ArrayList<>();
    private ArrayList<Restaurant> restaurants=new ArrayList<>();
    public Types chosenType;
    public Restaurant chosenRestaurant;

    private void addBars(){
        bars.add("Bar 108");
        Menu m = new Menu();// temporary thing
        restaurants.add(new Restaurant("Bar 108","","",m));// add some info for the bar
    }
    private void addCafes(){
        cafes.add("Starbucks");
        Menu m = new Menu();// temporary thing
        restaurants.add(new Restaurant("Starbucks","","",m));
    }
    private void addNormalRes(){
        normalRestaurants.add("Mcdonalds");
        Menu m = new Menu();// temporary thing
        restaurants.add(new Restaurant("Mcdonalds","","",m));
    }

    private void showBars(){
        int counter=0;
        for(String s:bars)
        {
            System.out.println(counter+"- "+s);
        }
    }
    private void showCafes(){
        int counter=0;
        for(String s:cafes)
        {
            System.out.println(counter+"- "+s);
        }
    }
    private void showNormalRes(){
        int counter=0;
        for(String s: normalRestaurants)
        {
            System.out.println(counter+"- "+s);
        }
    }

    public Application(){

    }


    public void showTypes(){
        int counter=0;
        for(String s:restaurantsTypes)
        {
            System.out.println(counter+"- "+s);
        }
    }


    public void selectType(Types type){
        switch (type){
            case Bar:
                chosenType=Types.Bar;
                break;
            case Cafe:
                chosenType= Types.Cafe;
                break;
            case normalRestaurant:
                chosenType=Types.normalRestaurant;
                break;
            default:
                System.out.println("Please choose one of the given restaurant types");
                break;
        }
    }

    public void unselectType(){
        chosenType=null;
    }

    public void showRestaurants(){
        switch (chosenType){
            case Bar:
                showBars();
                break;
            case Cafe:
                showCafes();
                break;
            case normalRestaurant:
                showNormalRes();
                break;
            default:
                System.out.println("Please choose one of the given restaurants");
                break;
        }
    }
    public void selectRes(String chosenRes){
        for(Restaurant restaurant:restaurants)
        {
            if(restaurant.name==chosenRes) {
                chosenRestaurant = restaurant;
                break;
            }
        }
    }
    public void unselectRes(){
        chosenRestaurant=null;
    }
    public void showMenu(Map<String, List<Item>> menu)
    {
        Set set=menu.entrySet();
        Iterator itr=set.iterator();
        while (itr.hasNext())
        {
            Map.Entry entry=(Map.Entry)itr.next();
            System.out.println(entry.getKey()+":");
            List<Item> list= (List<Item>) entry.getValue();
            for(Item item:list)
            {
                System.out.println(" -"+item);
            }
        }

    }
    public void makeOrder(){
        System.out.println("Welcome to restaurant "+chosenRestaurant.name);
        System.out.println("Choose from the menu and write finished when you are done");
        showMenu(chosenRestaurant.menu.getMenu());
        Order newOrder=new Order();
        Scanner scanner=new Scanner(System.in);
        String ItemName=scanner.next();

    }
}
