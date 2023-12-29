public class DealRule1 {
    private final GameData gameData = GameData.getInstance();
    public void applyRule(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            for (Player player : gameData.players) {
                Card card = gameData.deck.drawCard();
                player.addCardToHand(card);
            }
        }
    }
}
