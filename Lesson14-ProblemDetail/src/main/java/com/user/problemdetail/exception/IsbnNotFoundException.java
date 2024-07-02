package com.user.problemdetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

/**
 * @ClassName IsbnNotFoundException
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

//自定义异常类，让SpringMVC的异常处理器使用
public class IsbnNotFoundException extends ErrorResponseException {

    public IsbnNotFoundException(HttpStatus httpStatus,String detail){
        super(httpStatus,createProblemDetail(httpStatus,detail),null);
    }

    private static ProblemDetail createProblemDetail(HttpStatus httpStatus,String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, detail);
        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("书籍异常");
        problemDetail.setDetail(detail);

        //增加自定义异常信息
        problemDetail.setProperty("严重程度", "低");
        problemDetail.setProperty("客户邮箱","service@qq.com");

        return problemDetail;
    }
}
