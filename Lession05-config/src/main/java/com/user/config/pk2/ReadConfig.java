package com.user.config.pk2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @ClassName ReadConfig
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
public class ReadConfig {
    @Autowired
    private Environment environment;

    public void print(){
        //根据key 获取value
        String name = environment.getProperty("app.name");
        //判断key存不存在
        if (environment.containsProperty("app.owner")){
            String owner = environment.getProperty("app.owner");
            System.out.println("owner = " + owner);
        }
        //读取 key 转为需要的类型，提供默认值 8000
        Integer port = environment.getProperty("app.port", Integer.class, 8888);
        String result = String.format("读取的name:%s,端口为:%d", name, port);
        System.out.println("result:"+result);
    }
}
