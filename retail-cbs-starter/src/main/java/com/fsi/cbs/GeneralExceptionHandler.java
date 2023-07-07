package com.fsi.cbs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */

@ControllerAdvice
public class GeneralExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Customize the error message or perform any necessary actions
        String errorMessage = "An error occurred: " + ex.getMessage();

        // Return an appropriate HTTP response with the error message and status code
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

}
