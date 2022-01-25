package ch09_protection.introduce_null_object.example;

public class NavigationApplet {
    private MetaGraphicsContext graphicsContext;
    private MouseEventHandler mouseEventHandler;

    public void setting(MouseEventHandler mouseEventHandler, MetaGraphicsContext graphicsContext) {
        this.mouseEventHandler = mouseEventHandler;
        this.graphicsContext = graphicsContext;
    }

    public boolean mouseMove(Event event, int x, int y) {
        if (mouseEventHandler != null) {
            return mouseEventHandler.mouseMove(graphicsContext, event, x, y);
        }
        return true;
    }

    public boolean mouseDown(Event event, int x, int y) {
        if (mouseEventHandler != null) {
            return mouseEventHandler.mouseDown(graphicsContext, event, x, y);
        }
        return true;
    }

    public boolean mouseUp(Event event, int x, int y) {
        if (mouseEventHandler != null) {
            return mouseEventHandler.mouseUp(graphicsContext, event, x, y);
        }
        return true;
    }

    public boolean mouseEnter(Event event, int x, int y) {
        if (mouseEventHandler != null) {
            return mouseEventHandler.mouseEnter(graphicsContext, event, x, y);
        }
        return true;
    }

    public void doMouseClick(String imageMapName, String APID) {
        if (mouseEventHandler != null) {
            mouseEventHandler.doMouseClick(imageMapName, APID);
        }
    }
}
