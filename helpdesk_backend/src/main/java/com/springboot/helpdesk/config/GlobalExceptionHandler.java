package com.springboot.helpdesk.config;

import com.springboot.helpdesk.dto.Response.ErrorDto;
import com.springboot.helpdesk.exception.InvalidCallException;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(
            ResourceNotFoundException e
            ){
        return ResponseEntity.badRequest().body(new ErrorDto(e.getMessage(),"Id is not available in db", Instant.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ){
        //see we will have a big message when we use errordto and get message to simplify we use map
        Map<String,String> map = new HashMap<>();
        //it will get all the result like errors(it may have many error in same fields)
        BindingResult bindingResult = e.getBindingResult();
        //get every field error
        List<FieldError> list = bindingResult.getFieldErrors();
        //put them in map and get the field and its default error message
        list.forEach(fieldError->map.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(map);
    }
    @ExceptionHandler(InvalidCallException.class)
    public ResponseEntity<ErrorDto> handleInvalidCallException(InvalidCallException e){
        //always reply the object not the string
        return ResponseEntity.badRequest().body(
                new ErrorDto(e.getMessage(),
                        "call is Invalid due to malformed data",
                        Instant.now())
        );
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(
                new ErrorDto(e.getMessage(),
                        "PlanType should match one of the given Plantype in enum",
                              Instant.now())
        );
    }

}
