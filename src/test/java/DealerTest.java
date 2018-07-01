import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealerTest {

    @Test
    public void dealerShouldStopDrawingCardsWhenHandScoreIsHigherThanTargetScore() {
        Dealer dealer = Dealer.create();
        dealer.receiveCard(Card.create(Suit.DIAMONDS, Value.ACE));
        dealer.receiveCard(Card.create(Suit.DIAMONDS, Value.TWO));

        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.SPADES, Value.SIX),
                Card.create(Suit.HEARTS, Value.TWO),
                Card.create(Suit.DIAMONDS, Value.KING)
        ));

        assertEquals(13, dealer.getHand().getScore());
        assertEquals("dealer: DA, D2", dealer.toString());
        dealer.takeTurn(deck, 20);
        assertEquals(21, dealer.getHand().getScore());
        assertEquals("dealer: DA, D2, S6, H2", dealer.toString());
    }

    @Test
    public void dealerShouldNotDrawAnyCardsIfInitialHandScoreIsHigherThanTargetScore() {
        Dealer dealer = Dealer.create();
        dealer.receiveCard(Card.create(Suit.DIAMONDS, Value.ACE));
        dealer.receiveCard(Card.create(Suit.DIAMONDS, Value.EIGHT));

        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.SPADES, Value.SIX),
                Card.create(Suit.HEARTS, Value.TWO),
                Card.create(Suit.DIAMONDS, Value.KING)
        ));

        assertEquals(19, dealer.getHand().getScore());
        assertEquals("dealer: DA, D8", dealer.toString());
        dealer.takeTurn(deck, 18);
        assertEquals(19, dealer.getHand().getScore());
        assertEquals("dealer: DA, D8", dealer.toString());
    }

    @Test
    public void dealerShouldStopDrawingCardsWhenDeckEmpties() {
        Dealer dealer = Dealer.create();
        dealer.receiveCard(Card.create(Suit.DIAMONDS, Value.ACE));

        Deck deck = Deck.create(Collections.singletonList(
                Card.create(Suit.SPADES, Value.FIVE)
        ));

        assertEquals(11, dealer.getHand().getScore());
        assertEquals("dealer: DA", dealer.toString());
        dealer.takeTurn(deck, 18);
        assertEquals(16, dealer.getHand().getScore());
        assertEquals("dealer: DA, S5", dealer.toString());
    }
}
