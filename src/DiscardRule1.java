public class DiscardRule1 {
    private final GameData gameData = GameData.getInstance();
    public void applyRule(int cardIndex) {
        Card discardedCard = gameData.currentPlayer.getCard(cardIndex);
        gameData.discardPile.add(discardedCard);
        gameData.currentPlayer.discardCard(cardIndex);
    }
}
