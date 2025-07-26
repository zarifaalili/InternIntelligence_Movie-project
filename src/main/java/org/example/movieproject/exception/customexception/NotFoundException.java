package org.example.movieproject.exception.customexception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String movieNotFound) {
        super(movieNotFound);
    }
}
