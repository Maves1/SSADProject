public class Restaurant extends GeneralRestaurant {
    public Restaurant(String name, String address, String bankDetails, Menu menu) {
        super(name, address, bankDetails, menu);
        this.type = Type.Restaurant;
    }
}
