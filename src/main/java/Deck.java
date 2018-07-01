import java.util.*;

public class Deck {

    private Deque<Card> cardStack;

    private Deck() {
        this.cardStack = new ArrayDeque<>();
    }

    private Deck(List<Card> cards) {
        this.cardStack = new ArrayDeque<>(cards);
    }

    public Card drawACard() {
        return cardStack.pop();
    }

    public void shuffle() {
        List<Card> cards = new ArrayList<>(this.cardStack);
        Collections.shuffle(cards);
        this.cardStack = new ArrayDeque<>(cards);
        cards = null;
    }

    public static Deck createDefault() {
        return new Deck();
    }

    public static Deck createDeck(List<Card> cards) {
        return new Deck(cards);
    }

    public int size() {
        return cardStack.size();
    }
}
