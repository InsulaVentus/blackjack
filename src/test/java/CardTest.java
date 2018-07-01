import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void shouldBehaveAsExpected() {
        Card aceOfSpades = Card.create(Suit.SPADES, Value.ACE);
        assertEquals(11, aceOfSpades.getNumericalValue());
        assertEquals("SA", aceOfSpades.toString());
    }
}
