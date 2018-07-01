public class Player extends BlackjackPlayer {

    private String name;
    private BlackjackHand hand = BlackjackHand.createEmpty();

    private Player(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    BlackjackHand getHand() {
        return this.hand;
    }

    @Override
    void receiveCard(Card card) {
        this.hand.add(card);
    }

    void takeTurn(Deck deck) {
        while (deck.size() > 0 && this.hand.getScore() < 17) {
            receiveCard(deck.drawACard());
        }
    }

    public static Player create(String name) {
        return new Player(name);
    }
}
