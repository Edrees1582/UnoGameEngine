public class ReverseActionCard extends Card {
    private final GameData gameData = GameData.getInstance();
    public ReverseActionCard(Color color) {
        super(color, -1, 20, CardType.ACTION_REVERSE);
    }

    @Override
    public void applyAction() {
        gameData.dir.value *= -1;
        System.out.println("Game direction reversed!!");
    }
}
