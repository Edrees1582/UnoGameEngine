public class InitializeGameStandard {
    private final GameData gameData = GameData.getInstance();
    public void initializeGame() {
        System.out.println("Dealing cards...");

        gameData.gameRules.dealCards();

        gameData.topCard = gameData.deck.drawCard();
        while (gameData.topCard.getValue() == -1) gameData.topCard = gameData.deck.drawCard();

        gameData.deck.setCurrentColor(gameData.topCard.getColor());
    }
}
