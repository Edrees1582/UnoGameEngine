public class WildDrawFourCard extends Card {
    private final GameData gameData = GameData.getInstance();
    public WildDrawFourCard() {
        super(Color.NO_COLOR, -1, 50, CardType.WILD_DRAW_FOUR);
    }

    @Override
    public void applyAction() {
        for (int i = 0; i < 4; i++) {
            gameData.players.get(Math.abs((gameData.turn.value + gameData.dir.value) % gameData.players.size())).addCardToHand(gameData.deck.drawCard());
        }
        gameData.turn.value = Math.abs((gameData.turn.value + gameData.dir.value) % gameData.players.size());

        WildCard wildCard = new WildCard();
        wildCard.applyAction();

        System.out.println("Player[" + gameData.turn.value + "] WILD DRAW FOUR!");
    }
}
