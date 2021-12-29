package ch06_creation.introduce_polymorphic_creation_with_factory_method.example;

import ch06_creation.introduce_polymorphic_creation_with_factory_method.example.dummy.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DOMBuilderTest extends TestCase {
    private OutputBuilder builder;

    @Test
    void testAddAboveRoot() {
        String invalidResult =
        "<orders>" +
            "<order>" +
            "</order>" +
        "</orders>" +
        "<customer>" +
        "</customer>";
        builder = new DOMBuilder("orders");
        builder.addBelow("order");
        try {
            builder.addAbove("customer");
            fail("expecting java.lang.RuntimeException");
        } catch (RuntimeException ignored) {
        }
    }
}