package Cards;

import java.util.Stack;

public class CardsHandler {
    private static CardsHandler instance;
    private final Deck deck;
    private final Stack<Card> discardPile;

    private CardsHandler() {
        deck = new Deck();
        discardPile = new Stack<>();
    }

    public static CardsHandler getInstance() {
        if (instance == null) instance = new CardsHandler();
        return instance;
    }

    public Deck getDeck() {
        return deck;
    }

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public Card getTopCard() {
        return discardPile.peek();
    }
}
