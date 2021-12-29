package ch06_creation.encapsulate_classes_with_factory.example.descriptors;

public class DefaultDescriptor extends AttributeDescriptor {

    public DefaultDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        super(descriptorName, mapperType, forType);
    }
}
