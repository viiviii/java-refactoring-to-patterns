package ch07_simplification.replace_state_altering_conditionals_with_state.example;

public class SystemProfile {
    private boolean isUnixPermissionRequired;

    public SystemProfile(boolean isUnixPermissionRequired) {
        this.isUnixPermissionRequired = isUnixPermissionRequired;
    }

    public boolean isUnixPermissionRequired() {
        return isUnixPermissionRequired;
    }
}
