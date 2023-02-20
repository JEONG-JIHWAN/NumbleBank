package com.bankingserver.numblebank.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ExceptionResponse allExceptionHandler(Exception e) {
        log.error("[Exception]:", e);
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new ExceptionResponse(HttpStatus.BAD_REQUEST, e);
    }
}
