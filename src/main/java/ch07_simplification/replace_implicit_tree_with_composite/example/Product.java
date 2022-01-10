package ch07_simplification.replace_implicit_tree_with_composite.example;

public class Product {
    private final String id;
    private final String name;
    private final Color color;
    private final float price;
    private final Currency currency;
    private final ProductSize size;

    public Product(String id, String name, Color color, float price, Currency currency, ProductSize size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.currency = currency;
        this.size = size;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public ProductSize getSize() {
        return size;
    }
}
