public class PirateRules extends StandardRules implements GameRules {
    @Override
    public void discardCard(int cardIndex) {
        PirateDiscardRule pirateDiscardRule = new PirateDiscardRule();
        pirateDiscardRule.applyRule(cardIndex);
    }
}