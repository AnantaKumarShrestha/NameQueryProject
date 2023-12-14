package com.machnet.nameQueryProject.Exception;

import com.machnet.nameQueryProject.playLoad.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValid(RuntimeException e){
        String message=e.getMessage();
        String https=Integer.toString(HttpStatus.NOT_FOUND.value());
        ApiResponse apiResponse=new ApiResponse(message,https);
        return  new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

}
