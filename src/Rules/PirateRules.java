package Rules;

import Cards.CardsHandler;
import Game.GameRules;
import Player.PlayersHandler;
import Rules.Discard.PirateDiscardRule;

public class PirateRules extends StandardRules implements GameRules {
    @Override
    public void discardCard(PlayersHandler playersHandler, CardsHandler cardsHandler, int cardIndex) {
        PirateDiscardRule pirateDiscardRule = new PirateDiscardRule();
        pirateDiscardRule.applyRule(playersHandler, cardsHandler, cardIndex);
    }
}