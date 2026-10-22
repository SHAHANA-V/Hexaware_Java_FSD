package com.TaskManagement.Backend.config;

import com.TaskManagement.Backend.dto.Response.ErrorDto;
import com.TaskManagement.Backend.exception.OwnerShipException;
import com.TaskManagement.Backend.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(
            ResourceNotFoundException e
    ){
        return ResponseEntity.badRequest().body(new ErrorDto(e.getMessage(),"Id is not available in db", Instant.now()));
    }

    @ExceptionHandler(OwnerShipException.class)
    public ResponseEntity<ErrorDto> handleOwnerShipException(OwnerShipException e){
        return ResponseEntity.badRequest().body(new ErrorDto(
                e.getMessage(),
                "You do not have permission to modify this bus",
                Instant.now()
        ));
    }
}
