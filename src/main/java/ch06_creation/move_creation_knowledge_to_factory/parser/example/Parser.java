package ch06_creation.move_creation_knowledge_to_factory.parser.example;

public class Parser {
    private boolean shouldDecode;

    public void setStringNodeDecoding(boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldDecodeStringNodes() {
        return shouldDecode;
    }

    public void parse(String url) {
        StringParser stringParser = new StringParser(this);
        Node node = stringParser.find(url);
    }
}
