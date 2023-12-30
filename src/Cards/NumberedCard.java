package Cards;

import Game.Card;
import Game.CardType;
import Game.Color;

public class NumberedCard extends Card {
    public NumberedCard(Color color, int value) {
        super(color, value, value, CardType.NUMBERED);
    }

    @Override
    public void applyAction() {}
}
