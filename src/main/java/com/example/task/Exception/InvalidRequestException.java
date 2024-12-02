package com.example.task.Exception;

/**
 * Custom exception to be thrown when a request is invalid.
 */
public class InvalidRequestException extends RuntimeException {

    /**
     * Constructs a new InvalidRequestException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidRequestException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidRequestException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
