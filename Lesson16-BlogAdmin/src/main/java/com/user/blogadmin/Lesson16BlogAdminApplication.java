package com.user.blogadmin;

import com.user.blogadmin.settings.ArticleSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({ArticleSettings.class})
@MapperScan("com.user.blogadmin.mapper")
public class Lesson16BlogAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson16BlogAdminApplication.class, args);
	}

}
