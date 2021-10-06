public class Bar extends GeneralRestaurant {

    public Bar(String name, String address, String bankDetails, Menu menu) {
        super(name, address, bankDetails, menu);
        this.type = Type.Bar;
    }

    @Override
    public boolean receiveOrder(Order order) {
        if (Platform.checkIfLegal()) {
            super.receiveOrder(order);
            return true;
        } else {
            return false;
        }
    }
}
