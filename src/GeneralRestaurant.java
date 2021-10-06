import java.util.List;

public abstract class GeneralRestaurant {
    enum Type {
        Restaurant,
        Bar,
        Cafe
    }

    protected Type type;
    protected String name;
    protected String address;
    protected String bankDetails;
    protected Menu menu;
    protected List<Order> currentOrders;

    public GeneralRestaurant(String name, String address, String bankDetails, Menu menu) {
        this.name = name;
        this.address = address;
        this.bankDetails = bankDetails;
        this.menu = menu;
    }


    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean receiveOrder(Order order) {
        order.setOrderStatus(Order.Status.Cooking);
        currentOrders.add(order);
        return true;
    }

    public void changeOrderStatus(Order order, Order.Status newStatus) {
        order.setOrderStatus(newStatus);
    }

    private void notifyOrderStatusChanged() {
        // TODO: finish this
    }
}
