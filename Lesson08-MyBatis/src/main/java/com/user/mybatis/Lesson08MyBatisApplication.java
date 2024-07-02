package com.user.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.user.mybatis.mapper")
public class Lesson08MyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson08MyBatisApplication.class, args);
	}

}
