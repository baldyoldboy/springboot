package com.user.exceptionhandler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NumberController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class NumberController {


    @PostMapping("/divide")
    public String divide(Integer n1,Integer n2){
        int result = n1/n2;

        return "n1/n2 = "+result;
    }
}
