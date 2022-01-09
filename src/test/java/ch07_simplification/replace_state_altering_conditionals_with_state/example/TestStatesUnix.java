package ch07_simplification.replace_state_altering_conditionals_with_state.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStatesUnix {
    private SystemPermission permission;
    private SystemAdmin admin;

    @BeforeEach
    void setUp() {
        SystemUser user = new SystemUser();
        SystemProfile profile = new SystemProfile(true);
        permission = new SystemPermission(user, profile);
        admin = new SystemAdmin();
    }

    @Test
    void testGrantedBy() {
        permission.grantedBy(admin);
        assertEquals("requested", permission.REQUESTED, permission.state());
        assertEquals("not granted", false, permission.isGranted());
        permission.claimedBy(admin);
        permission.grantedBy(admin);
        assertEquals("granted", permission.GRANTED, permission.state());
        assertEquals("granted", true, permission.isGranted());
        assertEquals("granted", true, permission.isUnixPermissionGranted());
    }

    private void assertEquals(String message, Object expected, Object actual) {
        Assertions.assertEquals(expected, actual, message);
    }
}