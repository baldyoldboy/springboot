package com.user.problemdetail.config;

import com.user.problemdetail.record.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @ClassName BookContainer
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "product")
public class BookContainer {
    private List<Book> books;
}
