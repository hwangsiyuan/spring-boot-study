package com.hussein.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: OaExceptionHandler</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 11:29 AM
 */
@RestControllerAdvice
public class OaExceptionHandler {

    @ExceptionHandler(OaException.class)
    public Object handlerException(OaException exception) {
        Map<String, Object> result = new HashMap<>();
        if (exception instanceof LoginException) {
            LoginException loginException = (LoginException) exception;
            result.put("status", loginException.getStatus());
            result.put("tip", loginException.getTip());
        }
        return result;
    }
}
