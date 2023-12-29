import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PirateDiscardRule {
    private final GameData gameData = GameData.getInstance();
    public void applyRule(int cardIndex) {
        Card discardedCard = gameData.currentPlayer.getCard(cardIndex);
        gameData.discardPile.add(discardedCard);
        gameData.currentPlayer.discardCard(cardIndex);
        if (discardedCard.getValue() == 7 && gameData.currentPlayer.getHandSize() != 0) {
            System.out.println("Choose a player to trade hands with (-1 to pass):");
            for (Player player : gameData.players) {
                if (player.getIndex() != gameData.currentPlayer.getIndex()) {
                    System.out.println("Player[" + player.getIndex() + "]'s hand size: " + player.getHandSize());
                }
            }
            Scanner sc = new Scanner(System.in);
            int playerIndex = sc.nextInt();
            if (playerIndex == -1) System.out.println("Passed");
            else {
                Player tradedPlayer = gameData.players.get(playerIndex);
                ArrayList<Card> tradedPlayerHand = tradedPlayer.getCards();
                tradedPlayer.setHand(gameData.currentPlayer.getCards());
                gameData.currentPlayer.setHand(tradedPlayerHand);
                System.out.println("Your hand after trading:");
                gameData.currentPlayer.printHand();
            }
        }
        else if (discardedCard.getValue() == 0 && gameData.currentPlayer.getHandSize() != 0) {
            ArrayList<ArrayList<Card>> hands = new ArrayList<>();
            for (Player player : gameData.players) {
                hands.add(player.getCards());
            }

            Collections.rotate(hands, gameData.dir.value);

            for (int i = 0; i < gameData.players.size(); i++) {
               gameData.players.get(i).setHand(hands.get(i));
            }

            if (gameData.dir.value == 1)
                System.out.println("All players passed their hands CLOCKWISE");
            else if (gameData.dir.value == -1)
                System.out.println("All players passed their hands COUNTER-CLOCKWISE");
        }
    }
}
