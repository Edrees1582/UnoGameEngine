package Game;

import Game.Variations.*;
import Rules.*;

public class GameDriver {
    public static void main(String[] args) {
        StandardGame standardGameGame = new StandardGame(2, new StandardRules());
        standardGameGame.play();
    }
}