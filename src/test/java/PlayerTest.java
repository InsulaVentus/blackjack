import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void playerShouldStopDrawingCardsWhenHandScoreHits17() {
        Player sam = Player.create("sam");
        sam.receiveCard(Card.create(Suit.CLUBS, Value.FIVE));
        sam.receiveCard(Card.create(Suit.DIAMONDS, Value.TWO));

        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.SPADES, Value.FIVE),
                Card.create(Suit.HEARTS, Value.FIVE),
                Card.create(Suit.DIAMONDS, Value.KING)
        ));

        assertEquals(7, sam.getHand().getScore());
        assertEquals("sam: C5, D2", sam.toString());
        sam.takeTurn(deck);
        assertEquals(17, sam.getHand().getScore());
        assertEquals("sam: C5, D2, S5, H5", sam.toString());
    }

    @Test
    public void playerShouldNotDrawAnyCardsWhenInitialHandScoreIs17OrMore() {
        Player sam = Player.create("sam");
        sam.receiveCard(Card.create(Suit.CLUBS, Value.QUEEN));
        sam.receiveCard(Card.create(Suit.DIAMONDS, Value.SEVEN));

        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.SPADES, Value.FIVE),
                Card.create(Suit.HEARTS, Value.FIVE),
                Card.create(Suit.DIAMONDS, Value.KING)
        ));

        assertEquals(17, sam.getHand().getScore());
        assertEquals("sam: CQ, D7", sam.toString());
        sam.takeTurn(deck);
        assertEquals(17, sam.getHand().getScore());
        assertEquals("sam: CQ, D7", sam.toString());
    }

    @Test
    public void playerShouldStopDrawingCardsWhenDeckIsEmpty() {
        Player sam = Player.create("sam");
        sam.receiveCard(Card.create(Suit.CLUBS, Value.QUEEN));

        Deck deck = Deck.create(Collections.singletonList(
                Card.create(Suit.SPADES, Value.FIVE)
        ));

        assertEquals(10, sam.getHand().getScore());
        assertEquals("sam: CQ", sam.toString());
        sam.takeTurn(deck);
        assertEquals(15, sam.getHand().getScore());
        assertEquals("sam: CQ, S5", sam.toString());
    }
}
