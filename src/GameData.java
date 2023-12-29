import java.util.ArrayList;

public class GameData {
    private static GameData instance;
    protected IntegerWrapper turn; // player index
    protected IntegerWrapper dir;
    protected Deck deck;
    protected ArrayList<Player> players;
    protected Player currentPlayer;
    protected ArrayList<Card> discardPile;
    protected Card topCard;
    protected GameRules gameRules;
    private GameData(){}

    public static GameData getInstance() {
        if (instance == null) instance = new GameData();
        return instance;
    }
}
