package ch07_simplification.replace_state_altering_conditionals_with_state.example;

public class SystemPermission {
    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private boolean isGranted;
    private boolean isUnixPermissionGranted;
    private String state;

    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
    public final static String UNIX_CLAIMED = "UNIX_CLAIMED";

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = REQUESTED;
        isGranted = false;
        notifyAdminOfPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        if (!state.equals(REQUESTED) && !state.equals(UNIX_REQUESTED)) {
            return;
        }
        willBeHandleBy(admin);
        if (state.equals(REQUESTED)) {
            state = CLAIMED;
        } else if (state.equals(UNIX_REQUESTED)) {
            state = UNIX_CLAIMED;
        }
    }

    public void deniedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED)) {
            return;
        }
        if (!this.admin.equals(admin)) {
            return;
        }
        isGranted = false;
        isUnixPermissionGranted = false;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED)) {
            return;
        }
        if (!this.admin.equals(admin)) {
            return;
        }

        if (profile.isUnixPermissionRequired() && state.equals(UNIX_CLAIMED)) {
            isUnixPermissionGranted = true;
        } else if (profile.isUnixPermissionRequired() && !isUnixPermissionGranted()) {
            state = UNIX_REQUESTED;
            notifyUnixAdminsOfPermissionRequest();
            return;
        }
        state = GRANTED;
        isGranted = true;
        notifyUserOfPermissionRequestResult();
    }

    public String state() {
        return state;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    private void willBeHandleBy(SystemAdmin admin) {
        this.admin = admin;
    }

    private void notifyUnixAdminsOfPermissionRequest() {
        claimedBy(admin);
        grantedBy(admin);
    }

    private void notifyAdminOfPermissionRequest() {
    }

    private void notifyUserOfPermissionRequestResult() {
    }
}
