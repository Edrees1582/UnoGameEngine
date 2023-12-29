import java.util.Scanner;

public class WildCard extends Card {
    private final GameData gameData = GameData.getInstance();
    public WildCard() {
        super(Color.NO_COLOR, -1, 50, CardType.WILD);
    }

    @Override
    public void applyAction() {
        System.out.println("Current color: " + gameData.deck.getCurrentColor());
        System.out.println("Choose a color: ");
        for (int i = 0; i < Color.values().length - 2; i++)
            System.out.print(i + ": " + Color.values()[i] + " | ");

        System.out.println((Color.values().length - 2) + ": " + Color.values()[Color.values().length - 2]);
        Scanner sc = new Scanner(System.in);
        int colorIndex = sc.nextInt();
        gameData.deck.setCurrentColor(Color.values()[colorIndex]);
    }
}
