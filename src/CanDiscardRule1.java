public class CanDiscardRule1 {
    private final GameData gameData = GameData.getInstance();
    public boolean applyRule() {
        for (Card card : gameData.currentPlayer.getCards()) {
            if (card.getColor().equals(gameData.deck.getCurrentColor()) || (card.getValue() == gameData.topCard.getValue() && card.getType() == gameData.topCard.getType()) || card.getColor() == Color.NO_COLOR) {
                return true;
            }
        }
        return false;
    }
}
