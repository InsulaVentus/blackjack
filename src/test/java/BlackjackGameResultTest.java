import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameResultTest {

    @Test
    public void shouldPrintErrorIfErrorIsPresent() {
        BlackjackGameResult gameResult = BlackjackGameResult.BlackjackGameResultBuilder
                .create(Dealer.create(), Player.create("sam"))
                .withWinner(Dealer.create())
                .withError("foo")
                .build();

        assertEquals("Error: foo", gameResult.toString());
    }

    @Test
    public void shouldPrintSummaryWhenWinnerIsPresent() {
        Dealer dealer = Dealer.create();
        dealer.receiveCard(Card.create(Suit.SPADES, Value.ACE));

        Player player = Player.create("sam");
        player.receiveCard(Card.create(Suit.DIAMONDS, Value.ACE));

        BlackjackGameResult gameResult = BlackjackGameResult.BlackjackGameResultBuilder
                .create(dealer, player)
                .withWinner(dealer)
                .build();

        assertEquals("dealer\nsam: DA\ndealer: SA", gameResult.toString());
    }
}
