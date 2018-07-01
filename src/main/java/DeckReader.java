import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckReader {
    public static List<Card> readCardsFromFile(final String fromFile) {
        return Stream.of(fromFile)
                .map(DeckReaderTransformations::readDeckString)
                .flatMap(deckString -> DeckReaderTransformations.splitDeckStringIntoValues(deckString).stream())
                .map(DeckReaderTransformations::translateValueIntoCard)
                .collect(Collectors.toList());
    }
}
