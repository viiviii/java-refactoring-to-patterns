package ch10_accumulation.move_accumulation_to_collecting_parameter.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TagNodeTest {
    @Test
    void testOneChildWithAttribute() {
        //given
        TagNode productTag = new TagNode("product");
        TagNode priceTag = new TagNode("price");

        //when
        productTag.addAttribute("color", "red");
        priceTag.addAttribute("currency", "USD");
        productTag.add(priceTag);

        //then
        String expected =
            "<product color='red'>" +
                "<price currency='USD'>" +
                "</price>" +
            "</product>";
        assertEquals("price XML", expected, productTag.toString());
    }

    private void assertEquals(String message, Object expected, Object actual) {
        Assertions.assertEquals(expected, actual, message);
    }
}