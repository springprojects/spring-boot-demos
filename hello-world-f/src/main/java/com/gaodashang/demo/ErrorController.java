package com.gaodashang.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * comments.
 *
 * @author eva
 */
@ControllerAdvice
public class ErrorController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
/*
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public RuntimeException serverError(RuntimeException ex) {
        logger.error("Internal server error: {}, cause: {}", ex.getMessage(), ex.getCause());
        return ex;
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RuntimeException usernameError(Exception ex) {
        logger.error("Internal server error: {}, cause: {}", ex.getMessage(), ex.getCause());
        return new RuntimeException(ex);
    }
*/
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String unknownError(Exception e) throws RuntimeException {

        String error = "Ops! Unknown error occurred.";

        if(e != null) {
            if(StringUtils.hasText(e.getMessage())) {
                error = e.getMessage();
            } else if (e.getCause() != null &&
                    StringUtils.hasText(e.getCause().getMessage())) {
                error = e.getCause().getMessage();
            }
        }

        logger.error("Unknown error: {}", error);

        return error;
    }
/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public void handleBindingResultError() {
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception.class)
    public void handleUnauthorized() {
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleInternalServerError() {
    }
    */
}
