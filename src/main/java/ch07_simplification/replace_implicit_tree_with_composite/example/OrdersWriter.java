package ch07_simplification.replace_implicit_tree_with_composite.example;

import java.util.Locale;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml, order);
            xml.append("</order>");
        }
        xml.append("</orders>");
    }

    private void writeProductsTo(StringBuffer xml, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            xml.append("<product");
            xml.append(" id='");
            xml.append(product.getID());
            xml.append("'");
            xml.append(" color='");
            xml.append(colorFor(product));
            xml.append("'");
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                xml.append(" size='");
                xml.append(sizeFor(product));
                xml.append("'");
            }
            xml.append(">");
            writePriceTo(xml, product);
            xml.append(product.getName());
            xml.append("</product>");
        }
    }

    private void writePriceTo(StringBuffer xml, Product product) {
        xml.append("<price");
        xml.append(" currency='");
        xml.append(currencyFor(product));
        xml.append("'>");
        xml.append(product.getPrice());
        xml.append("</price>");
    }

    private String colorFor(Product product) {
        return product.getColor().name();
    }

    private String sizeFor(Product product) {
        return product.getSize().name().toLowerCase(Locale.ROOT);
    }

    private String currencyFor(Product product) {
        return product.getCurrency().name();
    }
}
