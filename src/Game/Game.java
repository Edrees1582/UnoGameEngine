package Game;

import java.util.ArrayList;

public abstract class Game {
    protected GameData gameData = GameData.getInstance();
    private final int initTurn;
    private final int initDir;
    public Game(int numberOfPlayers, int initTurn, int initDir, GameRules gameRules) {
        gameData.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            gameData.players.add(new Player(i));
        }
        gameData.turn = new IntegerWrapper(initTurn);
        gameData.dir = new IntegerWrapper(initDir);
        gameData.deck = new Deck();
        gameData.discardPile = new ArrayList<>();
        gameData.gameRules = gameRules;
        gameData.currentPlayer = gameData.players.get(gameData.turn.value);
        this.initTurn = initTurn;
        this.initDir = initDir;
    }

    public void play() {
        initializeGame();

        int j = 1;
        while (gameData.gameRules.checkGameWinner() == -1) {
            while (gameData.gameRules.checkRoundWinner() == -1) {
                gameData.currentPlayer = gameData.players.get(gameData.turn.value);

                System.out.println("Game.Player[" + gameData.currentPlayer.getIndex() + "]'s turn:");
                System.out.println("Game.Player[" + gameData.currentPlayer.getIndex() + "]'s hand:");
                gameData.currentPlayer.printHand();

                System.out.print("Top card: ");
                if (gameData.topCard.getType() == CardType.NUMBERED)
                    System.out.println(gameData.topCard.getColor() + " (" + gameData.topCard.getValue() + ")");
                else
                    System.out.println(gameData.topCard.getColor() + ", " + gameData.topCard.getType());

                System.out.println("Current color: " + gameData.deck.getCurrentColor());

                if (gameData.dir.value == 1)
                    System.out.println("Game.Game direction: CLOCKWISE");
                else if (gameData.dir.value == -1)
                    System.out.println("Game.Game direction: COUNTER-CLOCKWISE");

                for (int i = 0; i < gameData.players.size(); i++) {
                    if (i != gameData.turn.value) {
                        System.out.println("Number of cards in Game.Player[" + i + "]'s hand: " + gameData.players.get(i).getHandSize());
                    }
                }

                discarding();

                nextTurn();
            }

            int roundWinner = gameData.gameRules.checkRoundWinner();

            for (Player player : gameData.players) {
                if (player.getIndex() != roundWinner) {
                    player.setRoundScore();
                    gameData.players.get(roundWinner).setGameScore(player.getRoundScore());
                }
            }

            System.out.println("Game.Player[" + roundWinner + "] WON ROUND[" + j++ + "]!!");

            resetRound();
        }

        System.out.println("Final scores:");
        for (Player player : gameData.players) {
            System.out.println("Game.Player[" + player.getIndex() + "]: " + player.getGameScore());
        }
        System.out.println("Game.Player[" + gameData.players.get(gameData.gameRules.checkGameWinner()).getIndex() + "] is the WINNER!!!!!");
    }

    private void resetRound() {
        gameData.turn = new IntegerWrapper(initTurn);
        gameData.dir = new IntegerWrapper(initDir);
        gameData.deck = new Deck();
        gameData.discardPile = new ArrayList<>();
        gameData.topCard = null;
        for (Player player : gameData.players) {
            player.clearHand();
            player.resetRoundScore();
        }
        initializeGame();
    }

    protected abstract void initializeGame();
    protected abstract void discarding();
    protected abstract void nextTurn();
}
