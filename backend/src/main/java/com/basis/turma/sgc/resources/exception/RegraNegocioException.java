package com.basis.turma.sgc.resources.exception;

public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException(final String message) {
        this(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}