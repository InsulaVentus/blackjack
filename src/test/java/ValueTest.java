import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueTest {

    @Test
    public void shouldTranslateSymbolToValue() {
        assertEquals(Value.getValue("2"), Value.TWO);
        assertEquals(Value.getValue("3"), Value.THREE);
        assertEquals(Value.getValue("4"), Value.FOUR);
        assertEquals(Value.getValue("5"), Value.FIVE);
        assertEquals(Value.getValue("6"), Value.SIX);
        assertEquals(Value.getValue("7"), Value.SEVEN);
        assertEquals(Value.getValue("8"), Value.EIGHT);
        assertEquals(Value.getValue("9"), Value.NINE);
        assertEquals(Value.getValue("10"), Value.TEN);
        assertEquals(Value.getValue("J"), Value.JACK);
        assertEquals(Value.getValue("Q"), Value.QUEEN);
        assertEquals(Value.getValue("K"), Value.KING);
        assertEquals(Value.getValue("A"), Value.ACE);
    }
}
