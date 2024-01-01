package Cards;

import Game.Player.Player;
import Game.Player.PlayersHandler;

public class SkipActionCard extends Card {
    public SkipActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_SKIP);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        Player nextPlayer = playersHandler.getNextPlayer();
        System.out.println("Player[" + nextPlayer.getIndex() + "] got skipped!");
    }
}
