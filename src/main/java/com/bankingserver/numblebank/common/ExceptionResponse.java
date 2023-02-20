package com.bankingserver.numblebank.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionResponse {
    private int status;
    private String message;

    public ExceptionResponse(HttpStatus status, Throwable throwable) {
        this.status = status.value();
        this.message = throwable.getMessage();
    }
}
