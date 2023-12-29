public class CheckRoundWinner1 {
    private final GameData gameData = GameData.getInstance();
    public int applyRule() {
        for (Player player : gameData.players) {
            if (player.getHandSize() == 0) return player.getIndex();
        }
        return -1;
    }
}
