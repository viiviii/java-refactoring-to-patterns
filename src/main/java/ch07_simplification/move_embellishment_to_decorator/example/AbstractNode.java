package ch07_simplification.move_embellishment_to_decorator.example;

public abstract class AbstractNode implements Node {
    protected int nodeBegin;
    protected int nodeEnd;

    public AbstractNode(int nodeBegin, int nodeEnd) {
        this.nodeBegin = nodeBegin;
        this.nodeEnd = nodeEnd;
    }

    @Override
    public abstract String toPlainTextString();

    @Override
    public abstract String toHtml();
}
