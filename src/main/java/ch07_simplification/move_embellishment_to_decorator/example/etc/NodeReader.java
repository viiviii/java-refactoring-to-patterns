package ch07_simplification.move_embellishment_to_decorator.example.etc;

import ch07_simplification.move_embellishment_to_decorator.example.Node;
import ch07_simplification.move_embellishment_to_decorator.example.Parser;
import ch07_simplification.move_embellishment_to_decorator.example.StringParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class NodeReader extends BufferedReader {
    private final String url;
    private String line;
    private Parser parser;
    private StringParser stringParser = new StringParser();

    public NodeReader(Reader in, String url) {
        super(in);
        this.url = url;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Node readElement() {
        if (readNextLine()) {
            line = getNextLine();
            return stringParser.find(this, line, 0, false);

        }
        return null;
    }

    private boolean readNextLine() {
        return line == null;
    }

    public String getNextLine() {
        try {
            line = readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IOException!");

        }
        return null;
    }
}
