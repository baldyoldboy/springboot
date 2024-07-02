package com.user.problemdetail.exception;

/**
 * @ClassName BookNotFindException
 * @Description 书籍找不到异常
 * @Author 14036
 * @Version: 1.0
 */
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
