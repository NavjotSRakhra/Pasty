package io.github.navjotsrakhra.pasty;

import io.github.navjotsrakhra.pasty.exception.UsernameExistsException;
import io.github.navjotsrakhra.pasty.model.response.ErrorDto;
import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(UsernameExistsException e) {
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        log.error("Error UUID: {}, error message: {}", errorDto.getErrorId(), e.getMessage(), e);
        return ResponseEntity
                .badRequest()
                .body(errorDto);
    }
}

