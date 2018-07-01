import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Setup {
    public static List<Card> initiateDeck(final String fromFile) {
        return Stream.of(fromFile)
                .map(StringToDeck::readDeckString)
                .flatMap(deckString -> StringToDeck.splitDeckStringIntoValues(deckString).stream())
                .map(StringToDeck::translateValueIntoCard)
                .collect(Collectors.toList());
    }
}
