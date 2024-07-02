package com.user.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.user.transaction.mapper")
@EnableTransactionManagement
public class Lesson09TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson09TransactionApplication.class, args);
	}

}
