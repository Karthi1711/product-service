package com.oms.product.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class DomainToEntityConversionFailedException extends RuntimeException {

    public DomainToEntityConversionFailedException(String message) {
        super(message);
    }
}
