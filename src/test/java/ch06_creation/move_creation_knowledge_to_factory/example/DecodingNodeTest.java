package ch06_creation.move_creation_knowledge_to_factory.example;

import org.junit.jupiter.api.Test;

class DecodingNodeTest {

    @Test
    void testDecodeAmpersand() {
        String url = "test";
        Parser parser = new Parser();
        parser.setStringNodeDecoding(true);
        parser.parse(url);
    }
}