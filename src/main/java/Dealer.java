public class Dealer extends BlackjackPlayer {

    private BlackjackHand hand = BlackjackHand.createEmpty();

    @Override
    String getName() {
        return "dealer";
    }

    @Override
    BlackjackHand getHand() {
        return this.hand;
    }

    @Override
    void receiveCard(Card card) {
        this.hand.add(card);
    }

    void takeTurn(Deck deck, int scoreToBeat) {
        while (deck.size() > 0 && this.hand.getScore() <= scoreToBeat) {
            receiveCard(deck.drawACard());
        }
    }

    public static Dealer create() {
        return new Dealer();
    }
}
