package Cards;


import Player.Player;
import Player.PlayersHandler;

public class WildDrawFourCard extends Card {
    public WildDrawFourCard() {
        super(Color.NO_COLOR, -1, 50, CardType.WILD_DRAW_FOUR);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        Player nextPlayer = playersHandler.getNextPlayer();
        for (int i = 0; i < 4; i++) {
            nextPlayer.addCardToHand(cardsHandler.getDeck().drawCard());
        }
        WildCard wildCard = new WildCard();
        wildCard.applyAction(playersHandler, cardsHandler);

        System.out.println("Player[" + nextPlayer.getIndex() + "] WILD DRAW FOUR!");
    }
}
