package _06_creation.encapsulate_classes_with_factory.example.descriptors;

public class ReferenceDescriptor extends AttributeDescriptor {

    public ReferenceDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType, Class<?> forRemoteType) {
        super(descriptorName, mapperType, forType);
    }
}
