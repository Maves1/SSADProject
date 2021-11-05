package restaurants;

public class Item {
    private String name;
    private double price;

    public Item(String n, double price) {
        this.name = n;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
