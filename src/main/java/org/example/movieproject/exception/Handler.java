package org.example.movieproject.exception;

import org.example.movieproject.exception.customexception.AlreadyExistsException;
import org.example.movieproject.exception.customexception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> handleAlreadyExistsException(AlreadyExistsException ex) {
        return ResponseEntity
                .badRequest()
                .body(new Response(ex.getMessage(), "409"));

    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handle(RuntimeException e) {
        return ResponseEntity
                .badRequest()
                .body(new Response(e.getMessage(), "400"));

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handle(NotFoundException e) {
        return ResponseEntity
                .badRequest()
                .body(new Response(e.getMessage(), "404"));

    }
}
