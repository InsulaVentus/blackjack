import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackjackHandTest {

    @Test
    public void shouldBehaveAsExpected() {
        BlackjackHand blackjackHand = BlackjackHand.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE), Card.create(Suit.DIAMONDS, Value.KING)
        ));
        assertEquals(21, blackjackHand.getScore());
        assertEquals("CA, DK", blackjackHand.toString());
        blackjackHand.add(Card.create(Suit.SPADES, Value.ACE));
        assertEquals(32, blackjackHand.getScore());
        assertEquals("CA, DK, SA", blackjackHand.toString());
    }

    @Test
    public void shouldHaveAScoreOfZeroWhenHandIsEmpty() {
        BlackjackHand blackjackHand = BlackjackHand.createEmpty();
        assertEquals(0, blackjackHand.getScore());
        assertEquals("", blackjackHand.toString());
    }
}
