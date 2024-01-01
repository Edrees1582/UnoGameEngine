package Game;

import Cards.CardsHandler;
import Game.Player.PlayersHandler;

public abstract class Game {
    protected PlayersHandler playersHandler;
    protected CardsHandler cardsHandler;
    protected GameRules gameRules;

    public abstract void play();
    protected abstract void initializeGame();
    protected abstract void discarding();
    protected abstract void resetRound();
}
