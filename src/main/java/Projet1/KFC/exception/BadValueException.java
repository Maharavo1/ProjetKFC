package Projet1.KFC.exception;

public class BadValueException extends RuntimeException {
    public BadValueException(String message) {
        super((message));
    }
}
