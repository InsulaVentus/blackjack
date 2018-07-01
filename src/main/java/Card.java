import java.util.Objects;

public class Card {

    private final Suit suit;
    private final Value value;

    private Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static Card create(final Suit suit, final Value value) {
        return new Card(suit, value);
    }

    public int getNumericalValue() {
        return this.value.getNumericalValue();
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.suit.getShortHand(), this.value.getSymbol());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}
