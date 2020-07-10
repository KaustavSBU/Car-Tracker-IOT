package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Kaustav Sarkar
 *	Date : 07/09/2020
 *	Version : 1.0.0
 *
 *	Bad Request Exception: Just a custom exception, that extends the Runtime Exception, and throws in a custom error message
 */
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}