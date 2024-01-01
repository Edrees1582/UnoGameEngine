package Cards;

import Game.Player.Player;
import Game.Player.PlayersHandler;

public class DrawTwoActionCard extends Card {
    public DrawTwoActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_DRAW_TWO);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        Player nextPlayer = playersHandler.getNextPlayer();
        for (int i = 0; i < 2; i++) {
            nextPlayer.addCardToHand(cardsHandler.getDeck().drawCard());
        }
        System.out.println("Player[" + playersHandler.getCurrentPlayer().getIndex() + "] DRAW TWO!");
        playersHandler.getPreviousPlayer();
    }
}
