package Rules;

import Game.GameRules;
import Rules.Discard.PirateDiscardRule;

public class PirateRules extends StandardRules implements GameRules {
    @Override
    public void discardCard(int cardIndex) {
        PirateDiscardRule pirateDiscardRule = new PirateDiscardRule();
        pirateDiscardRule.applyRule(cardIndex);
    }
}