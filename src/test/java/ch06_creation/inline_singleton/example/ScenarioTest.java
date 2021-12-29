package ch06_creation.inline_singleton.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScenarioTest {

    @Test
    void testDealerStandsWhenPlayerBusts() {
        //given
        Console.setPlayerResponse(new TestAlwaysHitResponse());
        int[] deck = {10, 9, 7, 2, 6};
        Blackjack blackjack = new Blackjack(deck);

        //when
        blackjack.play();

        //then
        assertTrue("dealer wins", blackjack.didDealerWin());
        assertTrue("player loses", !blackjack.didPlayerWin());
        assertEquals("dealer total", 11, blackjack.getDealerTotal());
        assertEquals("player total", 23, blackjack.getPlayerTotal());
    }

    private void assertTrue(String message, boolean condition) {
        Assertions.assertTrue(condition, message);
    }

    private void assertEquals(String message, Object expected, Object actual) {
        Assertions.assertEquals(expected, actual, message);
    }
}