package _06_creation.encapsulate_classes_with_factory.example;


import _06_creation.encapsulate_classes_with_factory.example.descriptors.DefaultDescriptor;
import _06_creation.encapsulate_classes_with_factory.example.descriptors.ReferenceDescriptor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    @Test
    public void testCreateAttributeDescriptors() throws Exception {
        //given
        Mapper mapper = new Mapper();

        //when
        List descriptors = mapper.createAttributeDescriptors();

        //then
        assertTrue(descriptors.get(0) instanceof DefaultDescriptor);
        assertTrue(descriptors.get(1) instanceof DefaultDescriptor);
        assertTrue(descriptors.get(2) instanceof DefaultDescriptor);
        assertTrue(descriptors.get(3) instanceof ReferenceDescriptor);
        assertTrue(descriptors.get(4) instanceof ReferenceDescriptor);
        assertTrue(descriptors.get(5) instanceof DefaultDescriptor);
    }
}