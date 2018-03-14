package com.travix.medusa.busyflights.controller.error;

import java.util.stream.Collectors;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.travix.medusa.busyflights.domain.error.ApiError;

@RestControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(BindException.class)
    public ApiError requestParameterHandler(BindException e) {
        String bindErrors = e.getBindingResult().getFieldErrors().stream()
         .map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ApiError("API parameters error", bindErrors);
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleAnyError(Exception e) {
        return new ApiError("API request error", e.getMessage());
    }
}
