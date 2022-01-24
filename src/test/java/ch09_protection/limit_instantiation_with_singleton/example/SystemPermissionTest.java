package ch09_protection.limit_instantiation_with_singleton.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemPermissionTest {

    @Test
    void testDefaultsToPermissionRequested() {
        //given
        SystemUser user = new SystemUser();
        SystemProfile profile = new SystemProfile();

        //when
        SystemPermission permission = new SystemPermission(user, profile);

        //then
        assertTrue(permission.getState() instanceof PermissionRequested);
    }

    @Test
    void testClaimedBy() {
        //given
        SystemUser user = new SystemUser();
        SystemProfile profile = new SystemProfile();
        SystemPermission permission = new SystemPermission(user, profile);

        //when
        PermissionRequested requested = (PermissionRequested) permission.getState();
        requested.claimedBy(new SystemAdmin(), permission);

        //then
        assertTrue(permission.getState() instanceof PermissionClaimed);
    }
}