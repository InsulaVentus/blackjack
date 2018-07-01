import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    @Test
    public void shouldDoTheYouWhen() {
        Deck deck = Deck.createDeck(asList(Card.create(Suit.CLUBS, Value.ACE), Card.create(Suit.CLUBS, Value.FOUR)));
        assertEquals(deck.size(), 2);
        assertEquals(deck.drawACard(), Card.create(Suit.CLUBS, Value.ACE));
        assertEquals(deck.size(), 1);
        assertEquals(deck.drawACard(), Card.create(Suit.CLUBS, Value.FOUR));
        assertEquals(deck.size(), 0);
    }
}
