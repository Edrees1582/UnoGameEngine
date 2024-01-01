package Rules.NoValidCardPenalty;

import Cards.Card;
import Cards.CardsHandler;
import Game.Player.PlayersHandler;

public class NoValidCardPenaltyRule1 {
    public void applyRule(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        for (int i = 0; i < 1; i++) {
            Card card = cardsHandler.getDeck().drawCard();
            playersHandler.getCurrentPlayer().addCardToHand(card);
        }
    }
}
