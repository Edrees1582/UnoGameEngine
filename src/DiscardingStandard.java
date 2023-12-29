import java.util.Scanner;

public class DiscardingStandard {
    private final GameData gameData = GameData.getInstance();
    public void discarding() {
        Scanner sc = new Scanner(System.in);

        if (!gameData.gameRules.canDiscard()) {
            System.out.println("Player[" + gameData.currentPlayer.getIndex() + "]'s can't discard");
            gameData.gameRules.noValidCardPenalty();
            System.out.println("Player[" + gameData.currentPlayer.getIndex() + "]'s hand:");
            gameData.currentPlayer.printHand();
            if (!gameData.gameRules.canDiscard()) {
                System.out.println("Player[" + gameData.currentPlayer.getIndex() + "]'s can't discard");
                System.out.println("Next turn");
            }
            else {
                System.out.println("Choose a card to discard:");
                int cardIndex = sc.nextInt();
                discardCard(cardIndex);
            }
        }
        else {
            System.out.println("Choose a card to discard:");
            int cardIndex = sc.nextInt();
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
