package ch07_simplification.move_embellishment_to_decorator.example.etc;

public class Translate {
    public static String decode(String string) {
        return string.replaceAll("&amp;", "&");
    }
}
