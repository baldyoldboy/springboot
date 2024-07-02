package com.user.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello World!";
    }
}
