package com.example.demo.exception;

public class EstudanteNotFound extends RuntimeException{

    public EstudanteNotFound(String message) {
        super(message);
    }

    public EstudanteNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EstudanteNotFound(Throwable cause) {
        super(cause);
    }
}
