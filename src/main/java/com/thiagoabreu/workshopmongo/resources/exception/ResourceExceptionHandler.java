package com.thiagoabreu.workshopmongo.resources.exception;

import com.thiagoabreu.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

        @ExceptionHandler(ObjectNotFoundException.class)
        public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request) {

            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError standardError = new StandardError(System.currentTimeMillis()
            , status.value(), "Not found", e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(standardError);
        }
}
