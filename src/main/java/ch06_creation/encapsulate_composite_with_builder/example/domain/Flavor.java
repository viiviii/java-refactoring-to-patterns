package ch06_creation.encapsulate_composite_with_builder.example.domain;

public class Flavor {

    private Requirement[] requirements = {};

    public Requirement[] getRequirements() {
        return requirements;
    }

    public void setRequirements(Requirement[] requirements) {
        this.requirements = requirements;
    }
}
