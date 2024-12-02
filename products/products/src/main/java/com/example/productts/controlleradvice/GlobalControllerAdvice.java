package com.example.productts.controlleradvice;

import com.example.productts.dtos.ErrorResponseDto;
import com.example.productts.exception.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidProduct(){
        ResponseEntity<ErrorResponseDto> response =
                new ResponseEntity<>(new ErrorResponseDto("invalid product id taken from global class"),
                        HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
