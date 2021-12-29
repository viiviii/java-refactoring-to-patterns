package _06_creation.encapsulate_composite_with_builder.example;

import _06_creation.encapsulate_composite_with_builder.example.domain.Activity;
import _06_creation.encapsulate_composite_with_builder.example.domain.Flavor;
import _06_creation.encapsulate_composite_with_builder.example.domain.Requirement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogWriterTest {

    @Test
    void testCatalogXmlForMethodWithActivity() {
        //given
        String expectedXml =
            "<activity>" +
                "<flavors/>" +
            "</activity>";

        Activity activity = new Activity();
        CatalogWriter catalogWriter = new CatalogWriter();

        //when
        String actual = catalogWriter.catalogXmlFor(activity);

        //then
        assertEquals(expectedXml, actual);
    }

    @Test
    void testCatalogXmlForMethodWithFlavor() {
        //given
        String expectedXml =
            "<activity>" +
                "<flavors>" +
                    "<flavor/>" +
                "</flavors>" +
            "</activity>";

        Activity activity = new Activity();
        CatalogWriter catalogWriter = new CatalogWriter();

        //when
        Flavor flavor = new Flavor();
        activity.addFlavor(flavor);
        String actual = catalogWriter.catalogXmlFor(activity);

        //then
        assertEquals(expectedXml, actual);
    }

    @Test
    void testCatalogXmlForMethodWithRequirement() {
        //given
        String expectedXml =
            "<activity>" +
                "<flavors>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement/>" +
                        "</requirements>" +
                    "</flavor>" +
                "</flavors>" +
            "</activity>";

        Activity activity = new Activity();
        CatalogWriter catalogWriter = new CatalogWriter();

        //when
        Flavor flavor = new Flavor();
        Requirement requirement = new Requirement();
        flavor.setRequirements(new Requirement[]{requirement});
        activity.addFlavor(flavor);
        String actual = catalogWriter.catalogXmlFor(activity);

        //then
        assertEquals(expectedXml, actual);
    }
}