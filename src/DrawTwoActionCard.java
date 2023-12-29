public class DrawTwoActionCard extends Card {
    private final GameData gameData = GameData.getInstance();
    public DrawTwoActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_DRAW_TWO);
    }

    @Override
    public void applyAction() {
        for (int i = 0; i < 2; i++) {
            gameData.players.get(Math.abs((gameData.turn.value + gameData.dir.value) % gameData.players.size())).addCardToHand(gameData.deck.drawCard());
        }
        System.out.println("Player[" + (gameData.currentPlayer.getIndex() + 1) + "] DRAW TWO!");
    }
}
