package com.user.problemdetail.handler;

import com.user.problemdetail.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author 14036
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(BookNotFoundException.class)
//    public ProblemDetail handlerBookNotFoundException(BookNotFoundException e){
//        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
//        detail.setType(URI.create("/api/probs/not-found"));
//        detail.setTitle("图书异常");
//
//        //增加自定义属性
//        Map<String,Object> map = new HashMap<>();
//        Instant now = Instant.now();
//        map.put("timestamp", now);
//        map.put("客服邮箱","service@qq.com");
//        detail.setProperties(map);
//        return detail;
//    }

    @ExceptionHandler(BookNotFoundException.class)
    public ErrorResponse handlerException(BookNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.NOT_FOUND,e);
        return errorResponse;
    }

}
