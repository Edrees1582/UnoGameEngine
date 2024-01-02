package Rules.CheckRoundWinner;

import Player.Player;
import Player.PlayersHandler;

public class CheckRoundWinner1 {
    public int applyRule(PlayersHandler playersHandler) {
        for (Player player : playersHandler.getPlayers()) {
            if (player.getHandSize() == 0) return player.getIndex();
        }
        return -1;
    }
}
