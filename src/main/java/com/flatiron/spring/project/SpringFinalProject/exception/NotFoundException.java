package com.flatiron.spring.project.SpringFinalProject.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}