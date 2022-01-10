package ch07_simplification.replace_implicit_tree_with_composite.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersWriterTest {

    @Test
    void testGetContent() {
        //given
        String expectedResult =
        "<orders>" +
            "<order id='321'>"+
                "<product id='f1234' color='red' size='medium'>" +
                    "<price currency='USD'>" +
                        "8.95" +
                    "</price>" +
                    "File Truck" +
                "</product>" +
            "</order>"+
        "</orders>";
        Product product = new Product("f1234", "File Truck", Color.red, 8.95f, Currency.USD, ProductSize.MEDIUM);
        Order order = new Order("321");
        order.addProduct(product);
        Orders orders = new Orders(order);
        OrdersWriter ordersWriter = new OrdersWriter(orders);

        //when
        String actualResult = ordersWriter.getContents();

        //then
        assertEquals(expectedResult, actualResult);
    }
}