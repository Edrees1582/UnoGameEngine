package Game;

import Game.Variations.*;
import Rules.*;

public class GameDriver {
    public static void main(String[] args) {
        StandardGame standardGame = new StandardGame(2, new StandardRules());
        standardGame.play();
    }
}