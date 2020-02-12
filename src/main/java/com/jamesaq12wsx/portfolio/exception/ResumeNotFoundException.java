package com.jamesaq12wsx.portfolio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Portfolio Not Found")
public class ResumeNotFoundException extends Exception {

    public ResumeNotFoundException() {
    }

    public ResumeNotFoundException(String message) {
        super(message);
    }

    public ResumeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResumeNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResumeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
