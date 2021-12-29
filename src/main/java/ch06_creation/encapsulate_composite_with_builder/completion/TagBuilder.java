package ch06_creation.encapsulate_composite_with_builder.completion;

public class TagBuilder {
    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
        currentNode = rootNode;
    }

    public String toXml() {
        return rootNode.toString();
    }

    public void addAttribute(String name, String value) {
        currentNode.addAttribute(name, value);
    }

    public void addValue(String value) {
        currentNode.addValue(value);
    }

    public void addChild(String childTagName) {
        addTo(currentNode, childTagName);
    }

    public void addSibling(String siblingTagName) {
        addTo(currentNode.getParent(), siblingTagName);
    }

    public void addToParent(String parentTagName, String childTagName) {
        TagNode parentNode = findParentBy(parentTagName);
        if (parentNode == null) {
            throw new RuntimeException("missing parent tag: " + parentTagName);
        }
        addTo(parentNode, childTagName);
    }

    private TagNode findParentBy(String parentName) {
        TagNode parentNode = currentNode;
        while (parentNode != null) {
            if (parentName.equals(parentNode.getName())) {
                return parentNode;
            }
            parentNode = parentNode.getParent();
        }
        return null;
    }

    private void addTo(TagNode parentNode, String tagName) {
        currentNode = new TagNode(tagName);
        parentNode.add(currentNode);
    }
}
