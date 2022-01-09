package ch07_simplification.move_embellishment_to_decorator.example;

import ch07_simplification.move_embellishment_to_decorator.example.etc.NodeIterator;
import ch07_simplification.move_embellishment_to_decorator.example.etc.NodeReader;

import java.io.StringReader;

public class Parser {
    private NodeReader reader;

    private Parser(NodeReader reader) {
        setReader(reader);
    }

    private void setReader(NodeReader reader) {
        this.reader = reader;
        reader.setParser(this);
    }

    public static Parser createParser(String inputHTML) {
        NodeReader reader = new NodeReader(new StringReader(inputHTML), "");
        return new Parser(reader);
    }

    public NodeIterator elements() {
        return new NodeIterator(reader);
    }
}
