package ch09_protection.limit_instantiation_with_singleton.example;

public class PermissionRequested extends Permission {
    public static final String NAME = "REQUESTED";

    public String name() {
        return NAME;
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandleBy(admin);
        permission.setState(new PermissionClaimed());
    }
}
