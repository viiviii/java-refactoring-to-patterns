package ch07_simplification.replace_implicit_tree_with_composite.example;

public class Orders {
    private Order[] orders;

    public Orders(Order... orders) {
        this.orders = orders;
    }

    public Order getOrder(int index) {
        return orders[index];
    }

    public int getOrderCount() {
        return orders.length;
    }
}
