package com.ss.eshopping.product.dashboard.Exception;


import org.springframework.http.HttpStatus;

/**
 * Exception thrown in this app
 * Created by shital on 2019-08-04 14:38.
 */

public class EshoppingException extends RuntimeException {
    private static final long serialVersionUID=1L;
    private HttpStatus status;
    private final String message;

    /**
     * Constructor
     */
    public EshoppingException() {
        this.message=null;
    }

    public EshoppingException(String message) {
        super(message);
        this.message = message;
    }

    public EshoppingException(String message, HttpStatus status, Throwable cause) {
        super(cause);
        this.message = message;
        this.status=status;
    }
    public EshoppingException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status=status;
    }

    public EshoppingException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
