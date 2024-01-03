package Exceptions;

public class EmptyDeckException extends RuntimeException {
    public EmptyDeckException() {
        super("Empty deck");
    }
}
