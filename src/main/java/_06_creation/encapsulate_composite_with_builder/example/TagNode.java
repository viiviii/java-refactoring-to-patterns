package _06_creation.encapsulate_composite_with_builder.example;

import java.util.ArrayList;
import java.util.List;

public class TagNode {
    private String tagName;
    private String attributes = "";
    private String value = "";
    private List<TagNode> children;

    public TagNode(String name) {
        this.tagName = name;
    }

    public void add(TagNode childNode) {
        children().add(childNode);
    }

    private List<TagNode> children() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void addAttribute(String name, String value) {
        attributes += " " + attribute(name, value);
    }

    public void addValue(String value) {
        this.value += value;
    }

    public String getName() {
        return tagName;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return selfClosing(openingTag());
        }
        return openingTag() + value + childTags() + closingTag();
    }

    private boolean isEmpty() {
        return value.isEmpty() && (children == null || children.isEmpty());
    }

    private String selfClosing(String openingTag) {
        return openingTag.replace(">", "/>");
    }

    private String openingTag() {
        return "<" + tagName + attributes + ">";
    }

    private String closingTag() {
        return "</" + tagName + ">";
    }

    private String childTags() {
        String tags = "";
        if (children == null) {
            return tags;
        }
        for (TagNode node : children) {
            tags += node.toString();
        }
        return tags;
    }

    private String attribute(String name, String value) {
        return name + "=" + "'" + value + "'";
    }
}
