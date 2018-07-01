public abstract class BlackjackPlayer {
    abstract String getName();
    abstract BlackjackHand getHand();
    abstract void drawCard();
    abstract void takeTurn();

    public String toString() {
        return String.format("%s: %s", getName(), getHand());
    }
}
