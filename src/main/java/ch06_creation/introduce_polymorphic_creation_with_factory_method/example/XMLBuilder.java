package ch06_creation.introduce_polymorphic_creation_with_factory_method.example;

public class XMLBuilder implements OutputBuilder {
    public XMLBuilder(String rootName) {
    }

    @Override
    public void addBelow(String tagName) {

    }

    @Override
    public void addAbove(String tagName) {
        throw new RuntimeException();
    }
}
