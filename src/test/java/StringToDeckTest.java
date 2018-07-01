import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringToDeckTest {

    @Test
    public void shouldReadDeckString() {
        assertEquals(StringToDeck.readDeckString("../../deck"), "CA, D5, H9, HQ, S8");
        assertEquals(StringToDeck.readDeckString("../../emptyDeck"), "");
        assertThrows(RuntimeException.class, () -> StringToDeck.readDeckString("doesNotExist"));
    }

    @Test
    public void shouldSplitIntoValues() {
        assertEquals(StringToDeck.splitDeckStringIntoValues("CA, D5, H9, HQ, S8"), asList("CA", "D5", "H9", "HQ", "S8"));
    }

    @Test
    public void shouldTranslateIntoCards() {
        assertEquals(StringToDeck.translateValueIntoCard("CA"), Card.create(Suit.CLUBS, Value.ACE));
        assertEquals(StringToDeck.translateValueIntoCard("H10"), Card.create(Suit.HEARTS, Value.TEN));
        assertEquals(StringToDeck.translateValueIntoCard("S2"), Card.create(Suit.SPADES, Value.TWO));
    }
}
