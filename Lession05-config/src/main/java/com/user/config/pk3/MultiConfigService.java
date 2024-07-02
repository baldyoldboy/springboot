package com.user.config.pk3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @ClassName MultiConfigService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
public class MultiConfigService {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Value("${spring.redis.password}")
    private String redisPwd;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;
    public void printValue(){
        StringJoiner joiner = new StringJoiner("-");
        String result = joiner.add(redisHost).add("" + redisPort).add(redisPwd).add(dbUrl).add(dbUsername).toString();
        System.out.println("result = " + result);
    }

}
