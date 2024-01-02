package Rules.CheckGameWinner;

import Player.Player;
import Player.PlayersHandler;

public class CheckGameWinner1 {
    public int applyRule(PlayersHandler playersHandler) {
        for (Player player : playersHandler.getPlayers()) {
            if (player.getGameScore() >= 100) {
                return player.getIndex();
            }
        }

        return -1;
    }
}
