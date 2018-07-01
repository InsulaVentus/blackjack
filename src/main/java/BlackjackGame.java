import java.util.List;

public class BlackjackGame {

    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private Deck deck;

    public void play() {
        if (deck.size() < 4) {
            throw new RuntimeException("Deck has to have at least 4 cards");
        }
        player.drawCard();
    }

    class BlackjackGameResult {
        private BlackjackPlayer winner;
        private BlackjackPlayer dealer;
        private BlackjackPlayer player;

        @Override
        public String toString() {
            return String.format("%s\n%s\n%s", winner.getName(), player, dealer);
        }
    }
}
