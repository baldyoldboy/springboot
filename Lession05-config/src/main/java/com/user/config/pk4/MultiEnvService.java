package com.user.config.pk4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName MulitEnvService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
public class MultiEnvService {
    @Value("${myapp.memo}")
    private String memo;

    @Value("${app.name}")
    private String name;

    @Value("${app.password}")
    private String password;

    public void print(){
        System.out.println("memo = " + memo+"name = "+name);
        System.out.println("password = " + password);
    }
}
