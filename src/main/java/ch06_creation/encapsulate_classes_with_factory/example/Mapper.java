package ch06_creation.encapsulate_classes_with_factory.example;

import ch06_creation.encapsulate_classes_with_factory.example.descriptors.DefaultDescriptor;
import ch06_creation.encapsulate_classes_with_factory.example.descriptors.ReferenceDescriptor;
import ch06_creation.encapsulate_classes_with_factory.example.domain.RemoteUser;
import ch06_creation.encapsulate_classes_with_factory.example.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mapper {

    protected List createAttributeDescriptors() {
        List result = new ArrayList<>();
        result.add(new DefaultDescriptor("remoteId", getClass(), Integer.TYPE));
        result.add(new DefaultDescriptor("createdDate", getClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate", getClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy", getClass(), User.class, RemoteUser.class));
        result.add(new ReferenceDescriptor("lastChangedBy", getClass(), User.class, RemoteUser.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", getClass(), Integer.TYPE));
        return result;
    }
}
