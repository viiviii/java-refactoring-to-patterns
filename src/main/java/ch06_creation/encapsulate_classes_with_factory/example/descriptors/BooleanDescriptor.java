package ch06_creation.encapsulate_classes_with_factory.example.descriptors;

public class BooleanDescriptor extends AttributeDescriptor{

    public BooleanDescriptor(String descriptorName, Class<?> mapperType, Class<Boolean> forType) {
        super(descriptorName, mapperType, forType);
    }
}
