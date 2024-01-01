package Rules.Deal;

import Cards.Card;
import Cards.CardsHandler;
import Game.Player.Player;
import Game.Player.PlayersHandler;

public class DealRule1 {
    public void applyRule(PlayersHandler playersHandler, CardsHandler cardsHandler, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            for (Player player : playersHandler.getPlayers()) {
                Card card = cardsHandler.getDeck().drawCard();
                player.addCardToHand(card);
            }
        }
    }
}
