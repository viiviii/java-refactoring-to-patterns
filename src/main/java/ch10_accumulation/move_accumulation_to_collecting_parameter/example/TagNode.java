package ch10_accumulation.move_accumulation_to_collecting_parameter.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {
    private String name;
    private String value = "";
    private StringBuffer attributes = new StringBuffer();
    private List<TagNode> children = new ArrayList<>();

    public TagNode(String name) {
        this.name = name;
    }

    public void add(TagNode child) {
        children.add(child);
    }

    public void addAttribute(String name, String value) {
        attributes.append(name);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    @Override
    public String toString() {
        String result = new String();
        result += "<" + name + " " + attributes + ">";
        Iterator it = children.iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            result += node.toString();
        }
        if (!value.equals("")) {
            result += value;
        }
        result += "</" + name + ">";
        return result;
    }
}
