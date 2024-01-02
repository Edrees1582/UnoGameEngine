package Cards;

import Exceptions.InvalidColorIndexException;
import Player.PlayersHandler;

import java.util.Scanner;

public class WildCard extends Card {
    public WildCard() {
        super(Color.NO_COLOR, -1, 50, CardType.WILD);
    }

    @Override
    public void applyAction(PlayersHandler playersHandler, CardsHandler cardsHandler) {
        cardsHandler.getDeck().printCurrentColor();
        for (int i = 0; i < Color.values().length - 2; i++)
            System.out.print(Color.values()[i] + "" + i + ": " + Color.values()[i].getColorName() + Color.NO_COLOR + " | ");

        System.out.println((Color.values()[Color.values().length - 2] + "" + (Color.values().length - 2) + ": " + Color.values()[Color.values().length - 2].getColorName() + Color.NO_COLOR));
        Scanner sc = new Scanner(System.in);
        int colorIndex = sc.nextInt();
        if (colorIndex >= 0 && colorIndex < Color.values().length - 1)
            cardsHandler.getDeck().setCurrentColor(Color.values()[colorIndex]);
        else
            throw new InvalidColorIndexException();
    }
}
