package Game;

import java.util.ArrayList;

public class GameData {
    private static GameData instance;
    public IntegerWrapper turn; // player index
    public IntegerWrapper dir;
    public Deck deck;
    public ArrayList<Player> players;
    public Player currentPlayer;
    public ArrayList<Card> discardPile;
    public Card topCard;
    public GameRules gameRules;
    private GameData(){}

    public static GameData getInstance() {
        if (instance == null) instance = new GameData();
        return instance;
    }
}
