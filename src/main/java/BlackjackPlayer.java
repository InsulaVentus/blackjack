public abstract class BlackjackPlayer {
    abstract String getName();
    abstract BlackjackHand getHand();
    abstract void receiveCard(Card card);

    public boolean hasBlackjack() {
        return getHand().getScore() == 21;
    }

    public boolean isBusted() {
        return getHand().getScore() > 21;
    }

    public int getScore() {
        return getHand().getScore();
    }

    public String toString() {
        return String.format("%s: %s", getName(), getHand());
    }
}
