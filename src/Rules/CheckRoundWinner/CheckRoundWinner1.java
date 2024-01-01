package Rules.CheckRoundWinner;

import Game.Player.Player;
import Game.Player.PlayersHandler;

public class CheckRoundWinner1 {
    public int applyRule(PlayersHandler playersHandler) {
        for (Player player : playersHandler.getPlayers()) {
            if (player.getHandSize() == 0) return player.getIndex();
        }
        return -1;
    }
}
