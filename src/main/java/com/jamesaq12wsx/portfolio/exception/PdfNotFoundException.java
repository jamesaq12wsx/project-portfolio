package com.jamesaq12wsx.portfolio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "PDF Resume Not Found")
public class PdfNotFoundException extends Exception {

    public PdfNotFoundException() {
    }

    public PdfNotFoundException(String message) {
        super(message);
    }

    public PdfNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PdfNotFoundException(Throwable cause) {
        super(cause);
    }

    public PdfNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
