package enigma.rent.car.app.controllers;

import enigma.rent.car.app.utils.responseWrapper.Res;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException (ConstraintViolationException e){
        return Res.renderJson(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handleUnexpectedTypeException (UnexpectedTypeException e){
        String message = "Required Field TIDAK BOLEH KOSONG";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return Res.renderJson(null, message, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException (RuntimeException e){
        return Res.renderJson(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid (MethodArgumentNotValidException e){
        String message = "Required Field TIDAK BOLEH KOSONG";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return Res.renderJson(null, message, status);
    }
    //Check
}
