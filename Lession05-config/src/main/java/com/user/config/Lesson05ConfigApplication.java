package com.user.config;

import com.user.config.pk8.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:/applicationContext.xml")
@SpringBootApplication
@ConfigurationPropertiesScan({"com.user.config.pk5","com.user.config.pk6","com.user.config.pk7"})
public class Lesson05ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Lesson05ConfigApplication.class, args);
        Person myPerson = applicationContext.getBean("myPerson", Person.class);
        System.out.println("myPerson = " + myPerson);
    }

}
