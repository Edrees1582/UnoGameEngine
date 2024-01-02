package Cards;

import Player.PlayersHandler;

public abstract class Card {
    private Color color;
    private final int value;
    private final int score;
    private final CardType type;

    public Card(Color color, int value, int score, CardType type) {
        this.color = color;
        this.value = value;
        this.score = score;
        this.type = type;
    }
    public Color getColor() {
        return color;
    }
    public int getValue() {
        return value;
    }
    public int getCardScore() {
        return score;
    }
    public CardType getType() {
        return type;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void printCard(int cardIndex) {
        if (type == CardType.NUMBERED)
            if (cardIndex == -1)
                System.out.println("Top card: " + color + color.getColorName() + " (" + value + ")" + Color.NO_COLOR);
            else
                System.out.print(color + "" + cardIndex + ": " + color.getColorName() + " (" + value + ")" + Color.NO_COLOR);
        else
            if (cardIndex == -1)
                System.out.println("Top card: " + color + color.getColorName() + ", " + type + Color.NO_COLOR);
            else
                System.out.print(color + "" + cardIndex + ": " + color.getColorName() + ", " + type + Color.NO_COLOR);
    }

    public abstract void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler);
}
