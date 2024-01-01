package Game.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersHandler {
    private static PlayersHandler instance;
    private final List<Player> players;
    private Player currentPlayer;
    private int turn;
    private int dir;

    private PlayersHandler() {
        players = new ArrayList<>();
        currentPlayer = null;
        turn = 0;
        dir = 1;
    }

    public static PlayersHandler getInstance() {
        if (instance == null) instance = new PlayersHandler();
        return instance;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i));
        }
        currentPlayer = players.get(0);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getDir() {
        return dir;
    }

    public void revDir() {
        dir = -dir;
    }

    public void reset() {
        for (Player player : players) {
            player.clearHand();
        }
        currentPlayer = players.get(0);
        turn = 0;
        dir = 1;
    }

    public Player getNextPlayer() {
        turn = (turn + dir) % players.size();
        if (turn < 0) turn = players.size() - 1;
        currentPlayer = players.get(turn);
        return getCurrentPlayer();
    }

    public Player getPreviousPlayer() {
        turn = (turn - dir) % players.size();
        if (turn < 0) turn = players.size() - 1;
        currentPlayer = players.get(turn);
        return getCurrentPlayer();
    }
}
