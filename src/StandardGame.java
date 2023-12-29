public class StandardGame extends Game {
    public StandardGame(int numberOfPlayers, int initTurn, int initDir, GameRules gameRules) {
        super(numberOfPlayers, initTurn, initDir, gameRules);
    }

    @Override
    protected void initializeGame() {
        InitializeGameStandard initializeGameStandard = new InitializeGameStandard();
        initializeGameStandard.initializeGame();
    }

    @Override
    protected void discarding() {
        DiscardingStandard discardingStandard = new DiscardingStandard();
        discardingStandard.discarding();
    }

    @Override
    protected void nextTurn() {
        NextTurnStandard nextTurnStandard = new NextTurnStandard();
        nextTurnStandard.nextTurn();
    }
}
