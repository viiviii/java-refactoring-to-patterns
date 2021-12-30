package ch07_simplification.compose_method.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void testAdd() {
        //given
        int expected = 3;
        List list = new List(5);

        //when
        list.add(expected);

        //then
        assertEquals(expected, list.get(0));
    }

    @Test
    void testAddGrowSize() {
        //given
        final int INITIAL_CAPACITY = 5;
        final int OVER_CAPACITY = INITIAL_CAPACITY + 1;
        List list = new List(INITIAL_CAPACITY);

        //when
        for (int i = 0; i < OVER_CAPACITY; i++) {
            list.add(i);
        }

        //then
        assertEquals(OVER_CAPACITY, list.size());
    }

    @Test
    void testCreateWithInvalidCapacity() {
        //given
        final int INVALID_CAPACITY = -1;

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new List(INVALID_CAPACITY));

        //then
        assertEquals("Illegal Capacity: " + INVALID_CAPACITY, e.getMessage());
    }
}