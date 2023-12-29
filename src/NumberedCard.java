public class NumberedCard extends Card {
    public NumberedCard(Color color, int value) {
        super(color, value, value, CardType.NUMBERED);
    }

    @Override
    public void applyAction() {}
}
