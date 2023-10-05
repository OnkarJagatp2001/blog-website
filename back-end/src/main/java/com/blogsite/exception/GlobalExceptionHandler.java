package com.blogsite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
public class GlobalExceptionHandler extends Exception { 
  
  
 @ExceptionHandler(UserNotFoundException.class) 
 public  ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) 
 { 
  ErrorResponse err=new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); 
  return new ResponseEntity<>(err,HttpStatus.NOT_FOUND); 
   
 } 
}
