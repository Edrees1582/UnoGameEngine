package Exceptions;

public class InvalidDiscardIndex extends RuntimeException {
    public InvalidDiscardIndex() {
        super("Invalid discard index");
    }
}
