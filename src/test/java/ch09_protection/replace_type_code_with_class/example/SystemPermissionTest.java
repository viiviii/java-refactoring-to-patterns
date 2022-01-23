package ch09_protection.replace_type_code_with_class.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemPermissionTest {

    @Test
    void testDefaultsToPermissionRequested() {
        SystemPermission permission = new SystemPermission();
        assertEquals(permission.REQUESTED, permission.getState());
        assertEquals("REQUESTED", permission.getState());
    }

    @Test
    void testClaimed() {
        //given
        SystemPermission permission = new SystemPermission();

        //when
        permission.claimed();

        //then
        assertEquals(SystemPermission.CLAIMED, permission.getState());
    }

    @Test
    void testDenied() {
        //given
        SystemPermission permission = new SystemPermission();

        //when
        permission.claimed();
        permission.denied();

        //then
        assertEquals(SystemPermission.DENIED, permission.getState());
    }

    @Test
    void testGranted() {
        //given
        SystemPermission permission = new SystemPermission();

        //when
        permission.claimed();
        permission.granted();

        //then
        assertEquals(SystemPermission.GRANTED, permission.getState());
    }
}