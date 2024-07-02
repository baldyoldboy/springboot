package com.user.servletfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan({"com.user.servletfilter.servlet","com.user.servletfilter.filter","com.user.servletfilter.listener"})
public class Lesson11ServletFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson11ServletFilterApplication.class, args);
	}

}
