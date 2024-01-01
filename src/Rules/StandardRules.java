package Rules;

import Cards.Card;
import Cards.CardsHandler;
import Game.GameRules;
import Game.Player.PlayersHandler;
import Rules.CheckGameWinner.CheckGameWinner1;
import Rules.CheckRoundWinner.CheckRoundWinner1;
import Rules.Deal.DealRule1;
import Rules.Discard.DiscardRule1;
import Rules.NoValidCardPenalty.NoValidCardPenaltyRule1;

public class StandardRules implements GameRules {
    @Override
    public void dealCards(PlayersHandler playersHandler, CardsHandler cardsHandler, int numberOfCards) {
        DealRule1 dealRule = new DealRule1();
        dealRule.applyRule(playersHandler, cardsHandler, numberOfCards);
    }

    @Override
    public void discardCard(PlayersHandler playersHandler, CardsHandler cardsHandler, int cardIndex) {
        DiscardRule1 discardRule1 = new DiscardRule1();
        discardRule1.applyRule(playersHandler, cardsHandler, cardIndex);
    }

    @Override
    public boolean canDiscard(CardsHandler cardsHandler, Card card) {
        DiscardRule1 discardRule1 = new DiscardRule1();
        return discardRule1.canDiscard(cardsHandler, card);
    }

    @Override
    public boolean haveDiscardableCards(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        DiscardRule1 discardRule1 = new DiscardRule1();
        return discardRule1.haveDiscardableCards(playersHandler, cardsHandler);
    }

    @Override
    public void noValidCardPenalty(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        NoValidCardPenaltyRule1 noValidCardPenaltyRule1 = new NoValidCardPenaltyRule1();
        noValidCardPenaltyRule1.applyRule(playersHandler, cardsHandler);
    }

    @Override
    public int checkRoundWinner(PlayersHandler playersHandler) {
        CheckRoundWinner1 checkRoundWinner1 = new CheckRoundWinner1();
        return checkRoundWinner1.applyRule(playersHandler);
    }

    @Override
    public int checkGameWinner(PlayersHandler playersHandler) {
        CheckGameWinner1 checkGameWinner1 = new CheckGameWinner1();
        return checkGameWinner1.applyRule(playersHandler);
    }
}
