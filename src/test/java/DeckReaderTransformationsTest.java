import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckReaderTransformationsTest {

    @Test
    public void shouldReadDeckString() {
        assertEquals("CA, D5, H9, HQ, S8", DeckReaderTransformations.readDeckString("../../deck") );
        assertEquals("", DeckReaderTransformations.readDeckString("../../emptyDeck"));
        assertThrows(RuntimeException.class, () -> DeckReaderTransformations.readDeckString("doesNotExist"));
    }

    @Test
    public void shouldSplitIntoValues() {
        assertEquals(asList("CA", "D5", "H9", "HQ", "S8"), DeckReaderTransformations.splitDeckStringIntoValues("CA, D5, H9, HQ, S8"));
        assertEquals(singletonList("CA"), DeckReaderTransformations.splitDeckStringIntoValues("CA"));
        assertIterableEquals(Collections.EMPTY_LIST, DeckReaderTransformations.splitDeckStringIntoValues(""));
    }

    @Test
    public void shouldTranslateIntoCards() {
        assertEquals(DeckReaderTransformations.translateValueIntoCard("CA"), Card.create(Suit.CLUBS, Value.ACE));
        assertEquals(DeckReaderTransformations.translateValueIntoCard("H10"), Card.create(Suit.HEARTS, Value.TEN));
        assertEquals(DeckReaderTransformations.translateValueIntoCard("S2"), Card.create(Suit.SPADES, Value.TWO));
    }
}
