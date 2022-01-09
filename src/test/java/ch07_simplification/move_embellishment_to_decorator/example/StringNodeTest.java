package ch07_simplification.move_embellishment_to_decorator.example;

import ch07_simplification.move_embellishment_to_decorator.example.etc.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class StringNodeTest {
    Parser parser;

    @Test
    void testDecodingAmpersand() throws Exception {
        String ENCODED_WORKSHOP_TITLE = "The Testing &amp; Refactoring Workshop";
        String DECODED_WORKSHOP_TITLE = "The Testing & Refactoring Workshop";

        assertEquals(
                "ampersand in string",
                DECODED_WORKSHOP_TITLE,
                parseToObtainDecodedResult(ENCODED_WORKSHOP_TITLE));
    }

    private String parseToObtainDecodedResult(String stringToDecode) throws ParseException {
        StringBuffer decodedContent = new StringBuffer();
        createParser(stringToDecode);

        NodeIterator nodes = parser.elements();

        while (nodes.hasMoreNodes()) {
            Node node = nodes.nextNode();
            if (node instanceof StringNode) {
                StringNode stringNode = (StringNode) node;
                decodedContent.append(Translate.decode(stringNode.toPlainTextString()));
            }
            if (node instanceof Tag) {
                decodedContent.append(node.toHtml());
            }

        }
        return decodedContent.toString();
    }

    private void createParser(String string) {
        parser = Parser.createParser(string);
    }

    private void assertEquals(String message, String expected, String actual) {
        Assertions.assertEquals(expected, actual, message);
    }
}