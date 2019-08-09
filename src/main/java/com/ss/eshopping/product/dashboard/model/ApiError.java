package com.ss.eshopping.product.dashboard.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by shital on 2019-08-04 15:43.
 */
public class ApiError implements Serializable {
    private static final long serialVersionUID=1L;
    private HttpStatus status;
    private String Message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;

        Message = message;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
