public class Launcher {
    public static void main(String[] args) {
        BlackjackGame.BlackjackGameBuilder gameBuilder = BlackjackGame.BlackjackGameBuilder
                .create(Player.create("sam"), Dealer.create());

        if (args.length > 0) {
            gameBuilder.withDeck(Deck.create(DeckReader.readCardsFromFile(args[0])));
        }

        System.out.println(gameBuilder.build().play());
    }
}
