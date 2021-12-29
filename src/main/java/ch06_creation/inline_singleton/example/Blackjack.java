package ch06_creation.inline_singleton.example;

import java.io.BufferedReader;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private BufferedReader input;

    public Blackjack(int[] deck) {
        player = new Player();
        dealer = new Dealer();
    }

    public void play() {
        deal();
        writeln(player.getHandAsString());
        writeln(dealer.getHandAsStringWithFirstCardDown());
        HitStayResponse hitStayResponse;
        do {
            write("H( it or S) tay: ");
            hitStayResponse = Console.obtainHitStayResponse(input);
            write(hitStayResponse.toString());
            if (hitStayResponse.shouldHit()) {
                dealCardTo(player);
                writeln(player.getHandAsString());
            }
        }
        while (canPlayerHit(hitStayResponse));
    }

    public boolean didDealerWin() {
        return true;
    }

    public boolean didPlayerWin() {
        return false;
    }

    public int getDealerTotal() {
        return 11;
    }

    public int getPlayerTotal() {
        return 23;
    }

    private boolean canPlayerHit(HitStayResponse hitStayResponse) {
        return false;
    }

    private void dealCardTo(Player player) {
    }

    private void deal() {
    }

    private void writeln(String s) {
    }

    private void write(String s) {
    }
}
