import com.sun.corba.se.impl.encoding.TypeCodeOutputStream;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.List;
enum Types{
    Bar,
    Cafe,
    Fast_food,
    Sea_food
}
class Restaurant{
    String name;
    Restaurant(String s){
        name=s;
    }
}

public class Application {
    private ArrayList<String> restaurantsTypes=new ArrayList<>();
    private ArrayList<String> bars=new ArrayList<>();
    private ArrayList<String> cafes=new ArrayList<>();
    private ArrayList<String> fastFoodRes=new ArrayList<>();
    private ArrayList<String> seaFoodRes=new ArrayList<>();
    private ArrayList<Restaurant> restaurants=new ArrayList<>();
    public Types chosenType;
    private void addResTypes(){
        restaurantsTypes.add("Bar");
        restaurantsTypes.add("Cafe");
        restaurantsTypes.add("Fast food");
        restaurantsTypes.add("Sea food");
    }

    private void addBars(){
        bars.add("Bar 108");
        restaurants.add(new Restaurant("Bar 108"));
    }
    private void addCafes(){
        cafes.add("Starbucks");

    }
    private void addFastFoodRes(){
        fastFoodRes.add("Mcdonalds");
    }
    private void addSeaFoodRes(){
        seaFoodRes.add("A sea food restaurant");
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
    private void showFastFoodRes(){
        int counter=0;
        for(String s:fastFoodRes)
        {
            System.out.println(counter+"- "+s);
        }
    }
    private void showSeaFoodRes(){
        int counter=0;
        for(String s:seaFoodRes)
        {
            System.out.println(counter+"- "+s);
        }
    }


    public Application(){
        addResTypes();

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
            case Fast_food:
                chosenType=Types.Fast_food;
                break;
            case Sea_food:
                chosenType=Types.Sea_food;
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
            case Fast_food:
                showFastFoodRes();
                break;
            case Sea_food:
                showSeaFoodRes();
                break;
            default:
                System.out.println("Please choose one of the given restaurants");
                break;
        }
    }
    public void selectRes(String chosenRes){

    }
}
