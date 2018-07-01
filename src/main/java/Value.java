public enum Value {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    private String symbol;
    private int numericalValue;

    Value(String symbol, int numericalValue) {
        this.symbol = symbol;
        this.numericalValue = numericalValue;
    }

    public static Value getValue(final String symbol) {
        if ("2".equals(symbol)) {
            return Value.TWO;
        } else if ("3".equals(symbol)) {
            return Value.THREE;
        } else if ("4".equals(symbol)) {
            return Value.FOUR;
        } else if ("5".equals(symbol)) {
            return Value.FIVE;
        } else if ("6".equals(symbol)) {
            return Value.SIX;
        } else if ("7".equals(symbol)) {
            return Value.SEVEN;
        } else if ("8".equals(symbol)) {
            return Value.EIGHT;
        } else if ("9".equals(symbol)) {
            return Value.NINE;
        } else if ("10".equals(symbol)) {
            return Value.TEN;
        } else if ("J".equals(symbol)) {
            return Value.JACK;
        } else if ("Q".equals(symbol)) {
            return Value.QUEEN;
        } else if ("K".equals(symbol)) {
            return Value.KING;
        } else if ("A".equals(symbol)) {
            return Value.ACE;
        } else {
            return null;
        }
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getNumericalValue() {
        return this.numericalValue;
    }
}
