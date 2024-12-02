import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        // Define color precedence
        int color1 = (c1.getSuit() == Suit.HEARTS || c1.getSuit() == Suit.DIAMONDS) ? 1 : 0;
        int color2 = (c2.getSuit() == Suit.HEARTS || c2.getSuit() == Suit.DIAMONDS) ? 1 : 0;

        if (color1 != color2) {
            return color1 - color2;
        }

        // Define suit precedence within each color
        int suitComparison = c1.getSuit().compareTo(c2.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        }

        // Compare by rank
        return c1.getRank().compareTo(c2.getRank());
    }
}
