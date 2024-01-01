package Game;

import Cards.Card;
import Cards.CardsHandler;
import Game.Player.PlayersHandler;

public interface GameRules {
    void dealCards(PlayersHandler playersHandler, CardsHandler cardsHandler, int numberOfCards);
    void discardCard(PlayersHandler playersHandler, CardsHandler cardsHandler, int cardIndex);
    boolean canDiscard(CardsHandler cardsHandler, Card card);
    boolean haveDiscardableCards(PlayersHandler playersHandler, CardsHandler cardsHandler);
    void noValidCardPenalty(PlayersHandler playersHandler, CardsHandler cardsHandler);
    int checkRoundWinner(PlayersHandler playersHandler);
    int checkGameWinner(PlayersHandler playersHandler);
}
