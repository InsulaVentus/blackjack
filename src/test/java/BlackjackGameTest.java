import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackjackGameTest {

    @Test
    public void playerWinsAfterDealersTurn() {
        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.NINE),
                Card.create(Suit.HEARTS, Value.QUEEN),
                Card.create(Suit.SPADES, Value.EIGHT)
        ));

        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .withDeck(deck)
                .build();

        assertEquals("sam\nsam: CA, H9\ndealer: D5, HQ, S8", game.play().toString());
    }

    @Test
    public void playerWinsAfterPlayersTurn() {
        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.QUEEN),
                Card.create(Suit.SPADES, Value.FIVE)
        ));

        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .withDeck(deck)
                .build();

        assertEquals("sam\nsam: CA, H5, S5\ndealer: D5, HQ", game.play().toString());
    }

    @Test
    public void playerWinsAfterHandIsDealt() {
        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.TEN),
                Card.create(Suit.SPADES, Value.EIGHT)
        ));

        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .withDeck(deck)
                .build();

        assertEquals("sam\nsam: CA, H10\ndealer: D5, S8", game.play().toString());
    }

    @Test
    public void gameFailsBecauseDeckHasFewerThanFourCards() {
        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.FIVE),
                Card.create(Suit.HEARTS, Value.TEN)
        ));

        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .withDeck(deck)
                .build();

        assertEquals("Error: Deck must contain at least four cards", game.play().toString());
    }

    @Test
    public void gameFailsBecausePlayersHaveEqualScoresWhenDeckIsEmpty() {
        Deck deck = Deck.create(Arrays.asList(
                Card.create(Suit.CLUBS, Value.ACE),
                Card.create(Suit.DIAMONDS, Value.ACE),
                Card.create(Suit.HEARTS, Value.TWO),
                Card.create(Suit.SPADES, Value.TWO)
        ));

        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .withDeck(deck)
                .build();

        assertEquals(
                "Error: Dealer and player have equal scores and there are no more cards in deck",
                game.play().toString()
        );
    }

    @Test
    public void shouldFindAWinnerWhenUsingDefaultDeck() {
        BlackjackGame game = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create())
                .build();

        assertTrue(game.play().toString().contains("sam: "));
    }
}
