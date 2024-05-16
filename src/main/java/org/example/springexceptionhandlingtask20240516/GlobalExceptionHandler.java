package org.example.springexceptionhandlingtask20240516;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    For the NoSuchElementException, you would generally use HttpStatus.NOT_FOUND (404) because it indicates that the requested resource could not be found.

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage noSuchElementException(NoSuchElementException ex) {
        //ex.printStackTrace();
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(Exception ex) {
        //ex.printStackTrace();
        return new ErrorMessage(ex.getMessage());
    }
}
