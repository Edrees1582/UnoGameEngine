package Game;

public interface GameRules {
    void dealCards();
    boolean canDiscard();
    void discardCard(int cardIndex);
    void noValidCardPenalty();
    int checkRoundWinner();
    int checkGameWinner();
}
