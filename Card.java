import java.util.HashMap;
import java.util.Map;

public class Card {
    private Suit suit;
    private Rank rank;
    private static final Map<Rank, String> rankMap = new HashMap<>();
    private static final Map<Suit, String> suitMap = new HashMap<>();

    static {
        rankMap.put(Rank.ACE, "A");
        rankMap.put(Rank.TWO, "2");
        rankMap.put(Rank.THREE, "3");
        rankMap.put(Rank.FOUR, "4");
        rankMap.put(Rank.FIVE, "5");
        rankMap.put(Rank.SIX, "6");
        rankMap.put(Rank.SEVEN, "7");
        rankMap.put(Rank.EIGHT, "8");
        rankMap.put(Rank.NINE, "9");
        rankMap.put(Rank.TEN, "10");
        rankMap.put(Rank.JACK, "J");
        rankMap.put(Rank.QUEEN, "Q");
        rankMap.put(Rank.KING, "K");

        suitMap.put(Suit.SPADES, "S");
        suitMap.put(Suit.CLUBS, "C");
        suitMap.put(Suit.HEARTS, "H");
        suitMap.put(Suit.DIAMONDS, "D");
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getImagePath() {
        return String.format("images/%s-%s.png", rankMap.get(rank), suitMap.get(suit));
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
