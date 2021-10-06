import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    enum Status {
        PickingItems,
        Cooking,
        Delivery,
        Finished
    }

    private Map<Item, Integer> items;
    private Status orderStatus;

    public Order() {
        items = new HashMap<>();
        orderStatus = Status.PickingItems;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addItem(Item item, int quantity) {
        if (orderStatus == Status.PickingItems) {
            items.put(item, quantity);
        }
    }

    public void removeItem(Item item) {
        if (orderStatus == Status.PickingItems) {
            items.remove(item);
        }
    }
}
