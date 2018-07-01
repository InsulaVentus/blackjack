import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackjackHandTest {

    @Test
    public void shouldInitializeCorrectly() {
        BlackjackHand blackjackHand = BlackjackHand.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE), Card.create(Suit.DIAMONDS, Value.KING)
        ));
        assertEquals(21, blackjackHand.getScore());
        blackjackHand.add(Card.create(Suit.SPADES, Value.ACE));
        assertEquals(32, blackjackHand.getScore());
    }

    @Test
    public void shouldHaveAScoreOfZeroWhenHandIsEmpty() {
        BlackjackHand blackjackHand = BlackjackHand.create();
        assertEquals(0, blackjackHand.getScore());
    }
}
