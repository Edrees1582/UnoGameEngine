public class NextTurnStandard {
    private final GameData gameData = GameData.getInstance();
    public void nextTurn() {
        gameData.turn.value = (gameData.turn.value + gameData.dir.value) % gameData.players.size();
        if (gameData.turn.value < 0) gameData.turn.value = gameData.players.size() - 1;
    }
}
