package ch06_creation.move_creation_knowledge_to_factory.example;

public class StringParser {
    private final Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node find(String str) {
        StringBuffer textBuffer = new StringBuffer(str);
        int textBegin = 0;
        int textEnd = str.length();
        return StringNode.createStringNode(
                textBuffer, textBegin, textEnd,
                parser.shouldDecodeStringNodes()
        );
    }
}
