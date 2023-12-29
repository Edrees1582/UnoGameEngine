public class CheckGameWinner1 {
    private final GameData gameData = GameData.getInstance();
    public int applyRule() {
        for (Player player : gameData.players) {
            if (player.getGameScore() >= 500) {
                return player.getIndex();
            }
        }

        return -1;
    }
}
