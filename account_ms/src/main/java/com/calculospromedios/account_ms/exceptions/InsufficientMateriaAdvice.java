package com.calculospromedios.account_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class InsufficientMateriaAdvice {
    @ResponseBody
    @ExceptionHandler(InsufficientMateriaException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String InsufficientMateriaAdvice(InsufficientMateriaException ex){
        return ex.getMessage();
    }
}
