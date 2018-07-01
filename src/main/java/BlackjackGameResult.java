public class BlackjackGameResult {
    private BlackjackPlayer winner;
    private BlackjackPlayer dealer;
    private BlackjackPlayer player;
    private String error;

    private BlackjackGameResult(BlackjackPlayer winner, BlackjackPlayer dealer, BlackjackPlayer player, String error) {
        this.winner = winner;
        this.dealer = dealer;
        this.player = player;
        this.error = error;
    }

    @Override
    public String toString() {
        if (error != null) {
            return String.format("Error: %s", error);
        } else {
            return String.format("%s\n%s\n%s", winner.getName(), player, dealer);
        }
    }

    public static class BlackjackGameResultBuilder {
        private BlackjackPlayer winner;
        private BlackjackPlayer dealer;
        private BlackjackPlayer player;
        private String error;

        private BlackjackGameResultBuilder(BlackjackPlayer dealer, BlackjackPlayer player) {
            this.dealer = dealer;
            this.player = player;
        }

        public static BlackjackGameResultBuilder create(BlackjackPlayer dealer, BlackjackPlayer player) {
            return new BlackjackGameResultBuilder(dealer, player);
        }

        public BlackjackGameResultBuilder withWinner(BlackjackPlayer winner) {
            this.winner = winner;
            return this;
        }

        public BlackjackGameResultBuilder withError(String error) {
            this.error = error;
            return this;
        }

        public BlackjackGameResult build() {
            return new BlackjackGameResult(this.winner, this.dealer, this.player, this.error);
        }
    }
}
