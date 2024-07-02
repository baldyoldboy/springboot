package com.user.problemdetail.controller;

import com.user.problemdetail.config.BookContainer;
import com.user.problemdetail.exception.IsbnNotFoundException;
import com.user.problemdetail.record.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName BookController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class BookController {

    @Autowired
    private BookContainer bookContainer;

    @GetMapping("/book/getBook")
    public Book getBook(String isbn){
        List<Book> books = bookContainer.getBooks();
        Optional<Book> findBook = books.stream().filter(book -> book.isbn().equals(isbn)).findFirst();
        if (findBook.isEmpty()) {
            //throw new BookNotFoundException("图书的isbn可能不存在。。。。");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "图书的isbn可能不存在。。。。");
        }
        return findBook.get();
    }
}
