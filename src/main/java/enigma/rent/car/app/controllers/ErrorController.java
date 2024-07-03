package enigma.rent.car.app.controllers;

import enigma.rent.car.app.utils.responseWrapper.ResponseWrapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException (ConstraintViolationException e){
        return ResponseWrapper.
    }
}
