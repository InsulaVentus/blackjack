import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class DeckReaderTransformations {

    public static String readDeckString(final String file) {
        try {
            return Files
                    .lines(FileSystems.getDefault().getPath(file))
                    .findFirst()
                    .orElse("");
        } catch (IOException e) {
            throw new RuntimeException(String.format("Could not read deck from: '%s'", file), e);
        }
    }

    public static List<String> splitDeckStringIntoValues(final String deckString) {
        return deckString.isEmpty() ? new ArrayList<>() : asList(deckString.split(", "));
    }

    public static Card translateValueIntoCard(final String cardString) {
        return Card.create(Suit.getSuit(cardString.substring(0, 1)), Value.getValue(cardString.substring(1)));
    }
}
