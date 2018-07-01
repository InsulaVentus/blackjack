import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuitTest {
    @Test
    public void shouldTranslateShorthandValuesToSuits() {
        assertEquals(Suit.getSuit("S"), Suit.SPADES);
        assertEquals(Suit.getSuit("D"), Suit.DIAMONDS);
        assertEquals(Suit.getSuit("H"), Suit.HEARTS);
        assertEquals(Suit.getSuit("C"), Suit.CLUBS);
    }
}
