package Game;

import Game.Variations.PirateGame;
import Rules.PirateRules;

public class GameDriver {
    public static void main(String[] args) {
        PirateGame pirateGame = new PirateGame(2, new PirateRules());
        pirateGame.play();
    }
}