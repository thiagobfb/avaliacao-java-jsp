package com.thiagobfb.avaliacaojavajsp.services.exception;

public class InvalidOutputException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidOutputException(String msg) {
        super(msg);
    }

    public InvalidOutputException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
