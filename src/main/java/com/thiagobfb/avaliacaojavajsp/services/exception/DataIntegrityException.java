package com.thiagobfb.avaliacaojavajsp.services.exception;

public class DataIntegrityException extends RuntimeException {
    private static final long serialVersionUID = -8702062276139599677L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
