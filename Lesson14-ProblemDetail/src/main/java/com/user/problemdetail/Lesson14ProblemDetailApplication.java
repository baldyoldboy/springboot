package com.user.problemdetail;

import com.user.problemdetail.config.BookContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BookContainer.class)
public class Lesson14ProblemDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson14ProblemDetailApplication.class, args);
    }

}
