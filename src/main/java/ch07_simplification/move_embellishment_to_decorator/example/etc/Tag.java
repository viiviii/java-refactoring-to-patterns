package ch07_simplification.move_embellishment_to_decorator.example.etc;

import ch07_simplification.move_embellishment_to_decorator.example.AbstractNode;

public class Tag extends AbstractNode {

    public Tag(int nodeBegin, int nodeEnd) {
        super(nodeBegin, nodeEnd);
    }

    @Override
    public String toPlainTextString() {
        return null;
    }

    @Override
    public String toHtml() {
        return null;
    }
}
