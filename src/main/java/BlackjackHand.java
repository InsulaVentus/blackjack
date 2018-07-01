import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BlackjackHand {

    private List<Card> cards;

    private int score;

    public BlackjackHand(Collection<Card> cards) {
        this.cards = new LinkedList<>(cards);
        this.score = cards
                .stream()
                .map(Card::getNumericalValue)
                .reduce(0, (x, y) -> x + y);
    }

    public static BlackjackHand create(Collection<Card> cards) {
        return new BlackjackHand(cards);
    }

    public static BlackjackHand create() {
        return new BlackjackHand(new LinkedList<>());
    }

    public void add(Card card) {
        cards.add(card);
        score += card.getNumericalValue();
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return cards
                .stream()
                .map(Card::toString)
                .reduce("", (x, y) -> String.format("%s, %s", x, y));
    }
}
