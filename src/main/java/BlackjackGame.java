public class BlackjackGame {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public BlackjackGame(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public BlackjackGameResult play() {

        BlackjackGameResult.BlackjackGameResultBuilder gameResultBuilder = BlackjackGameResult.BlackjackGameResultBuilder.create(dealer, player);

        if (deck.size() < 4) {
            return gameResultBuilder.withError("Deck must contain at least four cards").build();
        }

        player.receiveCard(deck.drawACard());
        dealer.receiveCard(deck.drawACard());
        player.receiveCard(deck.drawACard());
        dealer.receiveCard(deck.drawACard());

        if (player.hasBlackjack()) {
            return gameResultBuilder.withWinner(player).build();
        } else if (dealer.hasBlackjack()) {
            return gameResultBuilder.withWinner(dealer).build();
        }

        if (player.isBusted()) {
            return gameResultBuilder.withWinner(dealer).build();
        } else if (dealer.isBusted()) {
            return gameResultBuilder.withWinner(player).build();
        }

        player.takeTurn(deck);

        if (player.hasBlackjack()) {
            return gameResultBuilder.withWinner(player).build();
        } else if (player.isBusted()) {
            return gameResultBuilder.withWinner(dealer).build();
        }

        dealer.takeTurn(deck, player.getScore());

        if (dealer.isBusted()) {
            return gameResultBuilder.withWinner(player).build();
        }

        if (player.getScore() > dealer.getScore()) {
            return gameResultBuilder.withWinner(player).build();
        } else if (dealer.getScore() > player.getScore()) {
            return gameResultBuilder.withWinner(dealer).build();
        } else {
            return gameResultBuilder.withError("Dealer and player have equal scores and there are no more cards in deck").build();
        }
    }

    public static class BlackjackGameBuilder {

        private Player player;
        private Dealer dealer;
        private Deck deck;

        private BlackjackGameBuilder(Player player, Dealer dealer) {
            this.player = player;
            this.dealer = dealer;
        }

        public static BlackjackGameBuilder create(Player player, Dealer dealer) {
            return new BlackjackGameBuilder(player, dealer);
        }

        public BlackjackGameBuilder withDeck(Deck deck) {
            this.deck = deck;
            return this;
        }

        public BlackjackGame build() {
            return new BlackjackGame(this.player, this.dealer, this.deck == null ? Deck.createShuffledDefault() : this.deck);
        }
    }
}
