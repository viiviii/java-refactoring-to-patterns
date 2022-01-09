package ch07_simplification.move_embellishment_to_decorator.example;

public class StringNode extends AbstractNode {
    protected StringBuffer textBuffer;

    public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        super(textBegin, textEnd);
        this.textBuffer = textBuffer;
    }

    public String getText() {
        return textBuffer.toString();
    }

    public void setText(String text) {
        textBuffer = new StringBuffer(text);
    }

    @Override
    public String toPlainTextString() {
        return textBuffer.toString();
    }

    @Override
    public String toHtml() {
        return textBuffer.toString();
    }
}
