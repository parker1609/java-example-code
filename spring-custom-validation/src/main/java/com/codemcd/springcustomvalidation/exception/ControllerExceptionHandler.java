package com.codemcd.springcustomvalidation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, InvalidBindListException.class})
    public boolean handleBindException(Exception exception) {
        log.info("MethodArgumentNotValidException OR InvalidBindListException");

        return false;
    }
}
