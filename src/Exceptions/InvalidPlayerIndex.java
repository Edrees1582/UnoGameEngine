package Exceptions;

public class InvalidPlayerIndex extends RuntimeException {
    public InvalidPlayerIndex() {
        super("Invalid player index");
    }
}
