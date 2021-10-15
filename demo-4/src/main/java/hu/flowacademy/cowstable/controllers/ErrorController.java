package hu.flowacademy.cowstable.controllers;

import hu.flowacademy.cowstable.models.ErrorModel;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<?> handleStableNotFound() {
        return new ResponseEntity<>(
                Map.of("error", new ErrorModel("Nincs ilyen istálló!", null)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, ErrorModel> handleMethodArgumentNotValid() {
        return Map.of("error", new ErrorModel("Érvénytelen bemenet", null));
    }
}
