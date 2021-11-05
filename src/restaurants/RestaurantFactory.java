package restaurants;

public class RestaurantFactory {
    public GeneralRestaurant createRestaurant(
            GeneralRestaurant.Type type,
            Menu menu,
            String name,
            String address,
            String bankDetails) {
        switch (type) {
            case Bar -> {
                return new Bar(name, address, bankDetails, menu);
            }
            case Cafe -> {
                return new Cafe(name, address, bankDetails, menu);
            }
            default -> {
                return new Restaurant(name, address, bankDetails, menu);
            }
        }
    }
}
