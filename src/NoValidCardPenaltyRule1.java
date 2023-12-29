public class NoValidCardPenaltyRule1 {
    private final GameData gameData = GameData.getInstance();
    public void applyRule(int numberOfCardsToDraw) {
        for (int i = 0; i < numberOfCardsToDraw; i++) {
            Card card = gameData.deck.drawCard();
            gameData.currentPlayer.addCardToHand(card);
        }
    }
}
