package ch09_protection.introduce_null_object.example;

public class MouseEventHandler {
    private final Context context;

    public MouseEventHandler(Context context) {
        this.context = context;
    }

    public boolean mouseMove(MetaGraphicsContext graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseDown(MetaGraphicsContext graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseUp(MetaGraphicsContext graphicsContext, Event event, int x, int y) {
        return false;
    }

    public boolean mouseEnter(MetaGraphicsContext graphicsContext, Event event, int x, int y) {
        return false;
    }

    public void doMouseClick(String imageMapName, String APID) {
        /* ..something */
    }
}
