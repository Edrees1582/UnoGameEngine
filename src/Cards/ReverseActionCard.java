package Cards;

import Game.Player.PlayersHandler;

public class ReverseActionCard extends Card {
    public ReverseActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_REVERSE);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        playersHandler.revDir();
        System.out.println("Game direction reversed!!");
    }
}
