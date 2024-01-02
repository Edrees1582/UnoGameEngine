package Rules.Discard;

import Cards.Card;
import Cards.CardsHandler;
import Exceptions.InvalidPlayerIndex;
import Player.Player;
import Player.PlayersHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PirateDiscardRule {
    public void applyRule(PlayersHandler playersHandler, CardsHandler cardsHandler, int cardIndex) {
        Card discardedCard = playersHandler.getCurrentPlayer().getCard(cardIndex);
        cardsHandler.getDiscardPile().add(discardedCard);
        playersHandler.getCurrentPlayer().discardCard(cardIndex);
        if (discardedCard.getValue() == 7 && playersHandler.getCurrentPlayer().getHandSize() != 0) {
            System.out.println("Choose a player to trade hands with (-1 to pass):");
            for (Player player : playersHandler.getPlayers()) {
                if (player.getIndex() != playersHandler.getCurrentPlayer().getIndex()) {
                    System.out.println("Player[" + player.getIndex() + "]'s hand size: " + player.getHandSize());
                }
            }
            Scanner sc = new Scanner(System.in);
            int playerIndex = sc.nextInt();
            if (playerIndex == -1) System.out.println("Passed");
            else if (playerIndex >= 0 && playerIndex < playersHandler.getPlayers().size()) {
                Player tradedPlayer = playersHandler.getPlayers().get(playerIndex);
                List<Card> tradedPlayerHand = tradedPlayer.getCards();
                tradedPlayer.setHand(playersHandler.getCurrentPlayer().getCards());
                playersHandler.getCurrentPlayer().setHand(tradedPlayerHand);
                System.out.println("Your hand after trading:");
                playersHandler.getCurrentPlayer().printHand();
            }
            else
                throw new InvalidPlayerIndex();
        }
        else if (discardedCard.getValue() == 0 && playersHandler.getCurrentPlayer().getHandSize() != 0) {
            List<List<Card>> hands = new ArrayList<>();
            for (Player player : playersHandler.getPlayers()) {
                hands.add(player.getCards());
            }

            Collections.rotate(hands, playersHandler.getDir());

            for (int i = 0; i < playersHandler.getPlayers().size(); i++) {
               playersHandler.getPlayers().get(i).setHand(hands.get(i));
            }

            if (playersHandler.getDir() == 1)
                System.out.println("All players passed their hands CLOCKWISE");
            else if (playersHandler.getDir() == -1)
                System.out.println("All players passed their hands COUNTER-CLOCKWISE");
        }
    }
}
