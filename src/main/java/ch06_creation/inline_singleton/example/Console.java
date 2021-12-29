package ch06_creation.inline_singleton.example;

import java.io.BufferedReader;

public class Console {
    static private HitStayResponse hitStayResponse = new HitStayResponse();

    private Console() {
        super();
    }

    public static HitStayResponse obtainHitStayResponse(BufferedReader input) {
        hitStayResponse.readFrom(input);
        return hitStayResponse;
    }

    public static void setPlayerResponse(HitStayResponse newHitStayResponse) {
        hitStayResponse = newHitStayResponse;
    }
}
