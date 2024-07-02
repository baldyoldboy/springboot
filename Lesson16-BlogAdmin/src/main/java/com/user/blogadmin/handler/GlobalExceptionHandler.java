package com.user.blogadmin.handler;


import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String handlerBindException(BindException e, Model model){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        model.addAttribute("errorList", fieldErrors);
        return "errors/bindException";
    }


    @ExceptionHandler(Exception.class)
    public String handlerRootException(Exception e,Model model){
        model.addAttribute("msg", e.getMessage());
        return "errors/rootException";
    }
}
