package ch07_simplification.compose_method.example;

public class List {
    private boolean readOnly = false;
    private int size = 0;
    private Object[] elements;

    public List(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
    }

    public void add(Object element) {
        if (!readOnly) {
            int newSize = size + 1;
            if (newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
            elements[size++] = element;
        }
    }

    public Object get(int index) {
        return elements[index];
    }

    public int size() {
        return size;
    }
}
