import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckReaderTest {

    @Test
    public void shouldCorrectlyGetCardsFromFile() {
        List<Card> expectedCards = Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.NINE),
                Card.create(Suit.HEARTS, Value.QUEEN),
                Card.create(Suit.SPADES, Value.EIGHT)
        );
        assertIterableEquals(expectedCards, DeckReader.readCardsFromFile("../../deck"));
    }

    @Test
    public void shouldReturnEmptyListIfFileIsEmpty() {
        assertIterableEquals(Collections.EMPTY_LIST, DeckReader.readCardsFromFile("../../emptyDeck"));
    }
}
