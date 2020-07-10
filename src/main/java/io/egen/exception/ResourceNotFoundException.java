package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Kaustav Sarkar
 *	Date : 07/09/2020
 *	Version : 1.0.0
 *
 *	Resource Not Found Exception: Just a custom exception, that extends the Runtime Exception, and throws in a custom error message
 */

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}