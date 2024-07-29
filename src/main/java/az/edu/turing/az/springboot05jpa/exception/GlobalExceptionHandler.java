package az.edu.turing.az.springboot05jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<CustomExceptionResponse> handleProfileNotFoundException(ProfileNotFoundException ex) {
        CustomExceptionResponse response = new CustomExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setMessage(ex.getMessage());
        response.setDetails("Profile not found with provided id");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Other exception handlers
}
