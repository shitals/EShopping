package com.ss.eshopping.product.dashboard.Exception;

import com.ss.eshopping.product.dashboard.model.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by shital on 2019-08-04 15:42.
 */
@ControllerAdvice
public class EshoppingExceptionHandler {
    Logger logger = LoggerFactory.getLogger(EshoppingExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex){
        ApiError apiError;
        if(ex instanceof EshoppingException){
            EshoppingException psException=(EshoppingException) ex;
                apiError = new ApiError(psException.getStatus(),ex.getMessage());
        }else{
            logger.error("Exception occured {}",ex);
            apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());

        }
        return new ResponseEntity<>(apiError,new HttpHeaders(),apiError.getStatus());
    }
}
