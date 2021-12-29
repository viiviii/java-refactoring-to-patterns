package _06_creation.encapsulate_composite_with_builder.completion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagNodeTest {

    @Test
    void testParents() {
        //given
        TagNode root = new TagNode("root");
        assertNull(root.getParent());

        TagNode childNode = new TagNode("child");

        //when
        root.add(childNode);

        //then
        assertEquals(root, childNode.getParent());
        assertEquals("root", childNode.getParent().getName());
    }
}