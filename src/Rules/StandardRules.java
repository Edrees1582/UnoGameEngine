package Rules;

import Game.GameRules;
import Rules.CanDiscard.CanDiscardRule1;
import Rules.CheckGameWinner.CheckGameWinner1;
import Rules.CheckRoundWinner.CheckRoundWinner1;
import Rules.Deal.DealRule1;
import Rules.Discard.DiscardRule1;
import Rules.NoValidCardPenalty.NoValidCardPenaltyRule1;

public class StandardRules implements GameRules {
    @Override
    public void dealCards() {
        DealRule1 dealRule = new DealRule1();
        dealRule.applyRule(7);
    }

    @Override
    public boolean canDiscard() {
        CanDiscardRule1 canDiscardRule1 = new CanDiscardRule1();
        return canDiscardRule1.applyRule();
    }

    @Override
    public void discardCard(int cardIndex) {
        DiscardRule1 discardRule1 = new DiscardRule1();
        discardRule1.applyRule(cardIndex);
    }

    @Override
    public void noValidCardPenalty() {
        NoValidCardPenaltyRule1 noValidCardPenaltyRule1 = new NoValidCardPenaltyRule1();
        noValidCardPenaltyRule1.applyRule(1);
    }

    @Override
    public int checkRoundWinner() {
        CheckRoundWinner1 checkRoundWinner1 = new CheckRoundWinner1();
        return checkRoundWinner1.applyRule();
    }

    @Override
    public int checkGameWinner() {
        CheckGameWinner1 checkGameWinner1 = new CheckGameWinner1();
        return checkGameWinner1.applyRule();
    }
}
