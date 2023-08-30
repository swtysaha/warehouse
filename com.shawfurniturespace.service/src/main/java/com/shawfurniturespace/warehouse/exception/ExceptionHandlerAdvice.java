package com.shawfurniturespace.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handle the exception thrown by Controller
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(WareHouseException.class)
    public ResponseEntity handleException(WareHouseException e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }        
}