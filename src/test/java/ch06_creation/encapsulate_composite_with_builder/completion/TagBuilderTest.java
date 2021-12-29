package ch06_creation.encapsulate_composite_with_builder.completion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagBuilderTest {

    @Test
    void testBuildOneNode() {
        //given
        String expectedXml = "<flavors/>";

        //when
        String actualXml = new TagBuilder("flavors").toXml();

        //then
        assertXmlEquals(expectedXml, actualXml);
    }

    @Test
    void testBuildOneChild() {
        //given
        String expectedXml =
            "<flavors>" +
                "<flavor/>" +
            "</flavors>";

        //when
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        String actualXml = builder.toXml();

        //then
        assertXmlEquals(expectedXml, actualXml);
    }

    @Test
    void testBuildChildrenOfChildren() {
        //given
        String expectedXml =
            "<flavors>" +
                "<flavor>" +
                    "<requirements>" +
                        "<requirement/>" +
                    "</requirements>" +
                "</flavor>" +
            "</flavors>";

        //when
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");
        String actualXml = builder.toXml();

        //then
        assertXmlEquals(expectedXml, actualXml);
    }

    @Test
    void testBuildSibling() {
        //given
        String expectedXml =
            "<flavors>" +
                "<flavor1/>" +
                "<flavor2/>" +
            "</flavors>";

        //when
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        String actualXml = builder.toXml();

        //then
        assertXmlEquals(expectedXml, actualXml);
    }


    @Test
    void testRepeatingChildrenAndGrandChildren() {
        //given
        String expectedXml =
            "<flavors>" +
                "<flavor>" +
                    "<requirements>" +
                        "<requirement/>" +
                    "</requirements>" +
                "</flavor>" +
                "<flavor>" +
                    "<requirements>" +
                        "<requirement/>" +
                    "</requirements>" +
                "</flavor>" +
            "</flavors>";

        //when
        TagBuilder builder = new TagBuilder("flavors");
        for (int i = 0; i < 2; i++) {
            builder.addToParent("flavors", "flavor");
            builder.addChild("requirements");
            builder.addChild("requirement");
        }

        //then
        assertXmlEquals(expectedXml, builder.toXml());
    }

    @Test
    void testParentNameNotFound() {
        //given
        TagBuilder builder = new TagBuilder("flavors");

        //when, then
        try {
            for (int i = 0; i < 2; i++) {
                builder.addToParent("favors", "flavor"); // should be "flavors" not "favors"
                builder.addChild("requirements");
                builder.addChild("requirement");
            }
            fail("should not allow adding to parent that doesn't exist.");
        } catch (RuntimeException runtimeException) {
            String expectedErrormessage = "missing parent tag: favors";
            assertEquals(expectedErrormessage, runtimeException.getMessage());
        }
    }

    @Test
    void testAttributesAndValues() {
        //given
        String expectedXml =
            "<flavor name='Test-Driven Development'>" + // tag with attribute
                "<requirements>" +
                    "<requirement type='hardware'>" +
                        "1 computer for every 2 participants" + //  tag with value
                    "</requirement>" +
                    "<requirement type='software'>" +
                        "IDE" + // values
                    "</requirement>" +
                "</requirements>" +
            "</flavor>";

        //when
        TagBuilder builder = new TagBuilder("flavor");
        builder.addAttribute("name", "Test-Driven Development");
            builder.addChild("requirements");
                builder.addToParent("requirements", "requirement");
                builder.addAttribute("type", "hardware");
                builder.addValue("1 computer for every 2 participants");
                builder.addToParent("requirements", "requirement");
                builder.addAttribute("type", "software");
                builder.addValue("IDE");

        //then
        assertXmlEquals(expectedXml, builder.toXml());
    }

    private void assertXmlEquals(String expected, String actual) {
        assertEquals(expected, actual);
    }
}