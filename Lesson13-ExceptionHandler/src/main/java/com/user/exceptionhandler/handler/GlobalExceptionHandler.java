package com.user.exceptionhandler.handler;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
/**
 * 1.在类的上面加入@ControllerAdvice, @RestControllerAdvice
 *   灵活组合@ControllerAdvice 和 @ResponseBody
 * 2.在类中自定义方法，处理各种异常。
 *   方法定义同Controller类中的方法的定义
 */
//控制器增强，给Controller增加异常处理功能。 类似AOP的思想
//@ControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *@ExceptionHandler: 指定处理异常的方法
     *   位置：在方法的上面
     *   属性：是异常类的class数组 ，如果你的系统抛出的异常类型与@ExceptionHandler声明的相同，由当前方法处理异常
     */
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e,Model model){
        String errorMessage = e.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "exp";
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handlerRootException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("错误原因",e.getMessage());
        map.put("解决方法", "稍后重试");
        return map;
    }

    //处理JSR303 验证参数的异常
    //@ExceptionHandler({ BindException.class})
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String,Object> handlerJSR303Exception(MethodArgumentNotValidException e){
        System.out.println("=========JSR303==========");
        BindingResult result = e.getBindingResult();
        Map<String,Object> map = new HashMap<>();
        if (result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            for (int i = 0; i < errors.size(); i++) {
                FieldError error = errors.get(i);
                map.put(i+"-"+error.getField(),error.getDefaultMessage());
            }
        }
        return map;
    }

}
