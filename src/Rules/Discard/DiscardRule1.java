package Rules.Discard;

import Cards.Card;
import Cards.CardsHandler;
import Cards.Color;
import Player.PlayersHandler;

public class DiscardRule1 {
    public void applyRule(PlayersHandler playersHandler, CardsHandler cardsHandler, int cardIndex) {
        Card discardedCard = playersHandler.getCurrentPlayer().getCard(cardIndex);
        cardsHandler.getDiscardPile().add(discardedCard);
        playersHandler.getCurrentPlayer().discardCard(cardIndex);
    }

    public boolean canDiscard(CardsHandler cardsHandler, Card card) {
        return card.getColor().equals(cardsHandler.getDeck().getCurrentColor()) || (card.getValue() == cardsHandler.getTopCard().getValue() && card.getType() == cardsHandler.getTopCard().getType()) || card.getColor() == Color.NO_COLOR;
    }

    public boolean haveDiscardableCards(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        for (Card card : playersHandler.getCurrentPlayer().getCards()) {
            if (canDiscard(cardsHandler, card)) return true;
        }
        return false;
    }
}
