import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Deck {

    private static final List<Card> DEFAULT_DECK = Arrays.asList(
            Card.create(Suit.CLUBS, Value.TWO),
            Card.create(Suit.CLUBS, Value.THREE),
            Card.create(Suit.CLUBS, Value.FOUR),
            Card.create(Suit.CLUBS, Value.FIVE),
            Card.create(Suit.CLUBS, Value.SIX),
            Card.create(Suit.CLUBS, Value.SEVEN),
            Card.create(Suit.CLUBS, Value.EIGHT),
            Card.create(Suit.CLUBS, Value.NINE),
            Card.create(Suit.CLUBS, Value.TEN),
            Card.create(Suit.CLUBS, Value.JACK),
            Card.create(Suit.CLUBS, Value.QUEEN),
            Card.create(Suit.CLUBS, Value.KING),
            Card.create(Suit.CLUBS, Value.ACE),
            Card.create(Suit.DIAMONDS, Value.TWO),
            Card.create(Suit.DIAMONDS, Value.THREE),
            Card.create(Suit.DIAMONDS, Value.FOUR),
            Card.create(Suit.DIAMONDS, Value.FIVE),
            Card.create(Suit.DIAMONDS, Value.SIX),
            Card.create(Suit.DIAMONDS, Value.SEVEN),
            Card.create(Suit.DIAMONDS, Value.EIGHT),
            Card.create(Suit.DIAMONDS, Value.NINE),
            Card.create(Suit.DIAMONDS, Value.TEN),
            Card.create(Suit.DIAMONDS, Value.JACK),
            Card.create(Suit.DIAMONDS, Value.QUEEN),
            Card.create(Suit.DIAMONDS, Value.KING),
            Card.create(Suit.DIAMONDS, Value.ACE),
            Card.create(Suit.SPADES, Value.TWO),
            Card.create(Suit.SPADES, Value.THREE),
            Card.create(Suit.SPADES, Value.FOUR),
            Card.create(Suit.SPADES, Value.FIVE),
            Card.create(Suit.SPADES, Value.SIX),
            Card.create(Suit.SPADES, Value.SEVEN),
            Card.create(Suit.SPADES, Value.EIGHT),
            Card.create(Suit.SPADES, Value.NINE),
            Card.create(Suit.SPADES, Value.TEN),
            Card.create(Suit.SPADES, Value.JACK),
            Card.create(Suit.SPADES, Value.QUEEN),
            Card.create(Suit.SPADES, Value.KING),
            Card.create(Suit.SPADES, Value.ACE),
            Card.create(Suit.HEARTS, Value.TWO),
            Card.create(Suit.HEARTS, Value.THREE),
            Card.create(Suit.HEARTS, Value.FOUR),
            Card.create(Suit.HEARTS, Value.FIVE),
            Card.create(Suit.HEARTS, Value.SIX),
            Card.create(Suit.HEARTS, Value.SEVEN),
            Card.create(Suit.HEARTS, Value.EIGHT),
            Card.create(Suit.HEARTS, Value.NINE),
            Card.create(Suit.HEARTS, Value.TEN),
            Card.create(Suit.HEARTS, Value.JACK),
            Card.create(Suit.HEARTS, Value.QUEEN),
            Card.create(Suit.HEARTS, Value.KING),
            Card.create(Suit.HEARTS, Value.ACE)
    );

    private Deque<Card> cardStack;

    private Deck(List<Card> cards) {
        this.cardStack = new ArrayDeque<>(cards);
    }

    public Card drawACard() {
        return cardStack.pop();
    }

    public static Deck createShuffledDefault() {
        ArrayList<Card> cards = new ArrayList<>(DEFAULT_DECK);
        Collections.shuffle(cards);
        return new Deck(cards);
    }

    public static Deck create(List<Card> cards) {
        return new Deck(cards);
    }

    public int size() {
        return cardStack.size();
    }
}
