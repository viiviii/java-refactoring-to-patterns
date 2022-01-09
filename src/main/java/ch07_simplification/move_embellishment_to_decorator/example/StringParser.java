package ch07_simplification.move_embellishment_to_decorator.example;

import ch07_simplification.move_embellishment_to_decorator.example.etc.NodeReader;

public class StringParser {

    public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
        StringBuffer textBuffer = new StringBuffer(input);
        int textBegin = 0;
        int textEnd = input.length();
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}
