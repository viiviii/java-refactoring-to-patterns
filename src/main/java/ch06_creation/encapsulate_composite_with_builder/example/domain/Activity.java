package ch06_creation.encapsulate_composite_with_builder.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private List<Flavor> flavors = new ArrayList<>();

    public int getFlavorCount() {
        return flavors.size();
    }

    public Flavor getFlavor(int index) {
        return flavors.get(index);
    }

    public void addFlavor(Flavor flavor) {
        flavors.add(flavor);
    }
}
