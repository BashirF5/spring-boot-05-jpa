package az.edu.turing.az.springboot05jpa.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;

}
