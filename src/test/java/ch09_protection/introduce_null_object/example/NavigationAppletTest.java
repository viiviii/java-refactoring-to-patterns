package ch09_protection.introduce_null_object.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NavigationAppletTest {
    private final Event event = new Event();
    private final int x = 1;
    private final int y = 1;

    @Test
    void testAppletIsNotSetting() {
        //given
        NavigationApplet navigationApplet = new NavigationApplet();

        //then
        assertTrue(navigationApplet.mouseMove(event, x, y));
        assertTrue(navigationApplet.mouseDown(event, x, y));
        assertTrue(navigationApplet.mouseUp(event, x, y));
        assertTrue(navigationApplet.mouseEnter(event, x, y));
    }

    @Test
    void testAppletIsSettingComplete() {
        //given
        NavigationApplet navigationApplet = new NavigationApplet();

        //when
        MetaGraphicsContext context = new MetaGraphicsContext();
        MouseEventHandler handler = new MouseEventHandler(context);
        navigationApplet.setting(handler, context);

        //then
        assertFalse(navigationApplet.mouseMove(event, x, y));
        assertFalse(navigationApplet.mouseDown(event, x, y));
        assertFalse(navigationApplet.mouseUp(event, x, y));
        assertFalse(navigationApplet.mouseEnter(event, x, y));
    }
}