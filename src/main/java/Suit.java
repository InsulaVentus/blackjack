public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private String shortHand;

    Suit(String shortHand) {
        this.shortHand = shortHand;
    }

    public String getShortHand() {
        return shortHand;
    }

    public static Suit getSuit(final String shortHand) {
        if ("C".equals(shortHand)) {
            return Suit.CLUBS;
        } else if ("D".equals(shortHand)) {
            return Suit.DIAMONDS;
        } else if ("H".equals(shortHand)) {
            return Suit.HEARTS;
        } else if ("S".equals(shortHand)) {
            return Suit.SPADES;
        } else {
            return null;
        }
    }
}
