package com.codewithsuraj.blogg.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithsuraj.blogg.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>  resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
         ApiResponse apiResponse = new ApiResponse();
         apiResponse.setMessage(ex.getMessage());
         apiResponse.setSuccess(false);
         return ResponseEntity.status(404).body(apiResponse);   
    
    }

    // public ResponseEntity<Map<String, String>{

    }

