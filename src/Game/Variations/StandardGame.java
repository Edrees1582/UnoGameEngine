package Game.Variations;

import Cards.Card;
import Cards.CardsHandler;
import Cards.Color;
import Exceptions.InvalidCardIndexException;
import Exceptions.InvalidDiscardIndex;
import Game.Game;
import Game.GameRules;
import Player.Player;
import Player.PlayersHandler;

import java.util.Scanner;

public class StandardGame extends Game {
    public StandardGame(int numberOfPlayers, GameRules gameRules) {
        playersHandler = PlayersHandler.getInstance();
        cardsHandler = CardsHandler.getInstance();
        this.gameRules = gameRules;
        playersHandler.addPlayers(numberOfPlayers);
    }

    @Override
    public void play() {
        initializeGame();

        int j = 1;
        int gameWinner = gameRules.checkGameWinner(playersHandler);
        while (gameWinner == -1) {
            int roundWinner = gameRules.checkRoundWinner(playersHandler);
            System.out.println("*****************");
            while (roundWinner == -1) {
                Player currentPlayer = playersHandler.getCurrentPlayer();
                System.out.println("Player[" + currentPlayer.getIndex() + "]'s turn:");
                System.out.println("Player[" + currentPlayer.getIndex() + "]'s hand:");
                currentPlayer.printHand();

                Card topCard = cardsHandler.getTopCard();
                topCard.printCard(-1);

                cardsHandler.getDeck().printCurrentColor();

                printDirection();

                for (int i = 0; i < playersHandler.getPlayers().size(); i++) {
                    Player playerI = playersHandler.getPlayers().get(i);
                    if (playerI != currentPlayer) {
                        System.out.println("Player[" + i + "]'s hand size: " + playerI.getHandSize());
                    }
                }

                discarding();

                playersHandler.getNextPlayer();
                roundWinner = gameRules.checkRoundWinner(playersHandler);
            }

            for (Player player : playersHandler.getPlayers()) {
                if (player.getIndex() != roundWinner) {
                    player.setRoundScore();
                    playersHandler.getPlayers().get(roundWinner).setGameScore(player.getRoundScore());
                }
            }

            System.out.println("Player[" + roundWinner + "] WON ROUND[" + j++ + "]!!");
            System.out.println("*****************");

            resetRound();

            gameWinner = gameRules.checkGameWinner(playersHandler);
        }

        System.out.println("Final scores:");
        for (Player player : playersHandler.getPlayers()) {
            System.out.println("Player[" + player.getIndex() + "]: " + player.getGameScore());
        }
        System.out.println("Player[" + playersHandler.getPlayers().get(gameWinner).getIndex() + "] is the WINNER!!!!!");
    }

    private void printDirection() {
        if (playersHandler.getDir() == 1)
            System.out.println("Game direction: CLOCKWISE");
        else if (playersHandler.getDir() == -1)
            System.out.println("Game direction: COUNTER-CLOCKWISE");
    }

    @Override
    protected void initializeGame() {
        System.out.println("Dealing cards...");

        gameRules.dealCards(playersHandler, cardsHandler, 2);

        cardsHandler.getDiscardPile().add(cardsHandler.getDeck().drawCard());
        while (cardsHandler.getTopCard().getValue() == -1) cardsHandler.getDiscardPile().add(cardsHandler.getDeck().drawCard());

        cardsHandler.getDeck().setCurrentColor(cardsHandler.getTopCard().getColor());
    }

    @Override
    protected void discarding() {
        if (!gameRules.haveDiscardableCards(playersHandler, cardsHandler)) {
            System.out.println("-------- Player[" + playersHandler.getCurrentPlayer().getIndex() + "]'s can't discard --------");
            System.out.println("Penalty applied...");
            gameRules.noValidCardPenalty(playersHandler, cardsHandler);
            System.out.println("Player[" + playersHandler.getCurrentPlayer().getIndex() + "]'s hand:");
            playersHandler.getCurrentPlayer().printHand();
            if (!gameRules.haveDiscardableCards(playersHandler, cardsHandler)) {
                System.out.println("-------- Player[" + playersHandler.getCurrentPlayer().getIndex() + "]'s can't discard --------");
                System.out.println("******** Next turn ********");
            }
            else chooseDiscard();
        }
        else chooseDiscard();
    }

    private void discardCard(int cardIndex) {
        Card card = playersHandler.getCurrentPlayer().getCard(cardIndex);
        cardsHandler.getDiscardPile().add(card);
        if (cardsHandler.getTopCard().getColor() != Color.NO_COLOR)
            cardsHandler.getDeck().setCurrentColor(cardsHandler.getTopCard().getColor());
        gameRules.discardCard(playersHandler, cardsHandler, cardIndex);
        card.applyAction(playersHandler, cardsHandler);
    }

    private void chooseDiscard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a card to discard:");
        int cardIndex = sc.nextInt();
        if (cardIndex >= 0 && cardIndex < playersHandler.getCurrentPlayer().getHandSize())
            if (gameRules.canDiscard(cardsHandler, playersHandler.getCurrentPlayer().getCard(cardIndex)))
                discardCard(cardIndex);
            else
                throw new InvalidDiscardIndex();
        else
            throw new InvalidCardIndexException();
    }

    @Override
    protected void resetRound() {
        playersHandler.reset();

        initializeGame();
    }
}
