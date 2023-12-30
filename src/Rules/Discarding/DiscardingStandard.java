package Rules.Discarding;

import Game.Card;
import Game.Color;
import Game.GameData;
import Exceptions.InvalidCardIndexException;

import java.util.Scanner;

public class DiscardingStandard {
    private final GameData gameData = GameData.getInstance();
    public void discarding() {
        Scanner sc = new Scanner(System.in);

        if (!gameData.gameRules.canDiscard()) {
            System.out.println("Game.Player[" + gameData.currentPlayer.getIndex() + "]'s can't discard");
            gameData.gameRules.noValidCardPenalty();
            System.out.println("Game.Player[" + gameData.currentPlayer.getIndex() + "]'s hand:");
            gameData.currentPlayer.printHand();
            if (!gameData.gameRules.canDiscard()) {
                System.out.println("Game.Player[" + gameData.currentPlayer.getIndex() + "]'s can't discard");
                System.out.println("Next turn");
            }
            else {
                System.out.println("Choose a card to discard:");
                int cardIndex = sc.nextInt();
                if (cardIndex >= 0 && cardIndex < gameData.currentPlayer.getHandSize())
                    discardCard(cardIndex);
                else
                    throw new InvalidCardIndexException();
                discardCard(cardIndex);
            }
        }
        else {
            System.out.println("Choose a card to discard:");
            int cardIndex = sc.nextInt();
            if (cardIndex >= 0 && cardIndex < gameData.currentPlayer.getHandSize())
                discardCard(cardIndex);
            else
                throw new InvalidCardIndexException();
            discardCard(cardIndex);
        }
    }

    private void discardCard(int cardIndex) {
        Card card = gameData.currentPlayer.getCard(cardIndex);
        gameData.topCard = card;
        if (gameData.topCard.getColor() != Color.NO_COLOR)
            gameData.deck.setCurrentColor(gameData.topCard.getColor());
        gameData.gameRules.discardCard(cardIndex);
        card.applyAction();
    }
}
