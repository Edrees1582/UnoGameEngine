package Game;

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
    public void printCard() {
        if (type == CardType.NUMBERED)
            System.out.println(color + " (" + value + ")");
        else
            System.out.println(color + ", " + type);
    }

    public abstract void applyAction();

}
