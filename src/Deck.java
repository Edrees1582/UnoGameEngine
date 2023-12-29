import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private final ArrayList<Card> deck;
    private Color currentColor;

    public Deck() {
        deck = new ArrayList<>();
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        for (Color color : colors) {
            deck.add(new NumberedCard(color, 0));
            for (int i = 1; i <= 9; i++) {
                deck.add(new NumberedCard(color, i));
                deck.add(new NumberedCard(color, i));
            }

            for (int i = 0; i < 2; i++) {
                deck.add(new ReverseActionCard(color));
                deck.add(new SkipActionCard(color));
                deck.add(new DrawTwoActionCard(color));
            }
        }

        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard());
            deck.add(new WildDrawFourCard());
        }

        Collections.shuffle(deck, new Random(System.currentTimeMillis()));
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            Card card = deck.get(0);
            deck.remove(0);
            return card;
        } else {
            // Handle when the deck is empty
            return null;
        }
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}