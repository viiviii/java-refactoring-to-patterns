package _06_creation.encapsulate_composite_with_builder.example;

import _06_creation.encapsulate_composite_with_builder.example.domain.Activity;
import _06_creation.encapsulate_composite_with_builder.example.domain.Flavor;
import _06_creation.encapsulate_composite_with_builder.example.domain.Requirement;

public class CatalogWriter {

    public String catalogXmlFor(Activity activity) {
        TagNode activityTag = new TagNode("activity");

        TagNode flavorsTag = new TagNode("flavors");
        activityTag.add(flavorsTag);

        for (int i = 0; i < activity.getFlavorCount(); i++) {
            TagNode flavorTag = new TagNode("flavor");
            flavorsTag.add(flavorTag);
            Flavor flavor = activity.getFlavor(i);

            int requirementsCount = flavor.getRequirements().length;
            if (requirementsCount > 0) {
                TagNode requirementsTag = new TagNode("requirements");
                flavorTag.add(requirementsTag);
                for (int r = 0; r < requirementsCount; r++) {
                    Requirement requirement = flavor.getRequirements()[r];
                    TagNode requirementTag = new TagNode("requirement");

                    requirementsTag.add(requirementTag);
                }
            }
        }
        return activityTag.toString();
    }
}
