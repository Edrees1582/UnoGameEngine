import java.util.ArrayList;

public class Player {
    private final int index;
    private int roundScore;
    private int gameScore;
    private ArrayList<Card> hand;

    public Player(int index) {
        this.index = index;
        roundScore = 0;
        gameScore = 0;
        hand = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }
    public void setRoundScore() {
        for (Card card : hand) {
            roundScore += card.getCardScore();
        }
    }
    public void resetRoundScore() {
        roundScore = 0;
    }
    public int getRoundScore() {
        return roundScore;
    }
    public void setGameScore(int value) {
        gameScore += value;
    }

    public int getGameScore() {
        return gameScore;
    }
    public ArrayList<Card> getCards() {
        return hand;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    public int getHandSize() {
        return hand.size();
    }
    public void discardCard(int cardIndex) {
        hand.remove(cardIndex);
    }

    public Card getCard(int cardIndex) {
        return hand.get(cardIndex);
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void clearHand() {
        hand.clear();
    }

    public void printHand() {
        for (int i = 0; i < hand.size() - 1; i++) {
            Card card = hand.get(i);
            if (card.getType() == CardType.NUMBERED)
                System.out.print(i + ": " + card.getColor() + " (" + card.getValue() + ")" + " | ");
            else
                System.out.print(i + ": " + card.getColor() + ", " + card.getType() + " | ");
        }
        Card card = hand.get(hand.size() - 1);
        if (card.getType() == CardType.NUMBERED)
            System.out.println((hand.size() - 1) + ": " + card.getColor() + " (" + card.getValue() + ")");
        else
            System.out.println((hand.size() - 1) + ": " + card.getColor() + ", " + card.getType());
    }
}
