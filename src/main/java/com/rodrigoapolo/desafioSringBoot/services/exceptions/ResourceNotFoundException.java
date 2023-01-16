package com.rodrigoapolo.desafioSringBoot.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1663082570981985784L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
