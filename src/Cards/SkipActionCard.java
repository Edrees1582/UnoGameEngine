package Cards;

import Game.Card;
import Game.CardType;
import Game.Color;
import Game.GameData;

public class SkipActionCard extends Card {
    private final GameData gameData = GameData.getInstance();
    public SkipActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_SKIP);
    }

    @Override
    public void applyAction() {
        gameData.turn.value = Math.abs((gameData.turn.value + gameData.dir.value) % gameData.players.size());
        System.out.println("Game.Player[" + gameData.turn.value + "] got skipped!");
    }
}
