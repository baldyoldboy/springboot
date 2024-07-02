package com.user.config.pk1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @ClassName SomeService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
/**
 * 加了数据源后 配置信息全局通用 其中还是以application为主
 */
@PropertySource({"classpath:/application1.properties"})
public class SomeService {
    @Value("${app.name}")
    private String ads;
    @Value("${app.owner}")
    private String owner;
    @Value("${app.ports}")
    private Integer port;
    public void printValue(){
        StringJoiner joiner = new StringJoiner("-");
        String result = joiner.add(ads).add(owner).add(String.valueOf(port)).toString();
        System.out.println("result = " + result);
    }
}
