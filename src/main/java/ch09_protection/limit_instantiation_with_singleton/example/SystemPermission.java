package ch09_protection.limit_instantiation_with_singleton.example;

public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private Permission permission;
    private Permission state;

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = new PermissionRequested();
    }

    public void willBeHandleBy(SystemAdmin admin) {
        this.admin = admin;
    }

    public void setState(PermissionClaimed permissionClaimed) {
        state = permissionClaimed;
    }

    public Permission getState() {
        return state;
    }
}
