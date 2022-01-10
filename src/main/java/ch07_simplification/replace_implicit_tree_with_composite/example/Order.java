package ch07_simplification.replace_implicit_tree_with_composite.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String orderId;
    private List<Product> products = new ArrayList<>();

    protected Order(String orderId) {
        this.orderId = orderId;
    }

    public static Order create(String orderId, Product... products) {
        Order order = new Order(orderId);
        for (Product product : products) {
            order.addProduct(product);
        }
        return order;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getOrderId() {
        return orderId;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        return products.get(index);
    }
}
