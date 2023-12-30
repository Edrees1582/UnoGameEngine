package Exceptions;

public class InvalidColorIndexException extends RuntimeException {
    public InvalidColorIndexException() {
        super("Invalid color index");
    }
}
