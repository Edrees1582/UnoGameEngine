package Cards;

import Exceptions.InvalidColorIndexException;
import Game.Player.PlayersHandler;

import java.util.Scanner;

public class WildCard extends Card {
    public WildCard() {
        super(Color.NO_COLOR, -1, 50, CardType.WILD);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        System.out.println("Current color: " + cardsHandler.getDeck().getCurrentColor());
        System.out.println("Choose a color: ");
        for (int i = 0; i < Color.values().length - 2; i++)
            System.out.print(i + ": " + Color.values()[i] + " | ");

        System.out.println((Color.values().length - 2) + ": " + Color.values()[Color.values().length - 2]);
        Scanner sc = new Scanner(System.in);
        int colorIndex = sc.nextInt();
        if (colorIndex >= 0 && colorIndex < Color.values().length - 1)
            cardsHandler.getDeck().setCurrentColor(Color.values()[colorIndex]);
        else
            throw new InvalidColorIndexException();
    }
}
