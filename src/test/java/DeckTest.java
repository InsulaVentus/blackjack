import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    @Test
    public void sizeShouldDecreaseAsCardsAreDrawn() {
        Deck deck = Deck.create(asList(Card.create(Suit.CLUBS, Value.ACE), Card.create(Suit.CLUBS, Value.FOUR)));
        assertEquals(2, deck.size());
        assertEquals(Card.create(Suit.CLUBS, Value.ACE), deck.drawACard());
        assertEquals(1, deck.size());
        assertEquals(Card.create(Suit.CLUBS, Value.FOUR), deck.drawACard());
        assertEquals(0, deck.size());
    }

    @Test
    public void defaultShuffledDeckShouldHaveSize52() {
        Deck deck = Deck.createShuffledDefault();
        assertEquals(52, deck.size());
    }
}
