package com.subsmanagement.advice;

import com.subsmanagement.dto.CommonResponse;
import com.subsmanagement.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ClientExceptionAdvice {

    @ExceptionHandler(value = {IllegalArgumentException.class, NotFoundException.class})
    public CommonResponse<String> handleClientException(HttpServletRequest request, Exception ex){

        CommonResponse<String> commonResponse = null;
        if(ex instanceof IllegalArgumentException){
            commonResponse = new CommonResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        } else if(ex instanceof NotFoundException){
            commonResponse = new CommonResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        } else {
            commonResponse = new CommonResponse<>(-1, "UnknownError");
        }

        return commonResponse;
    }
}
