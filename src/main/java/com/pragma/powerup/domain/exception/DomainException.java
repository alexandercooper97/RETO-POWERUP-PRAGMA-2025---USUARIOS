package main.java.com.pragma.powerup.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
        System.err.println(message);
    }
}
