package com.user.quickweb.controller;

import com.user.quickweb.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName ParamController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class ParamController {

    @PostMapping("/param/json")
    public String getJsonData(User user){
        System.out.println("接收的 json："+user.toString());
        return "json 转为 User 对象"+user.toString();
    }

    @PostMapping("/param/string")
    public String getJson(String name,Integer age){
        System.out.println(name+"-----"+age);
        return name+"-----"+age;
    }

    /**
     * 接收 json array
     */


    @PostMapping("/param/JsonDataArray")
    public String getJsonDataArray(@RequestBody List<User> userList){
        System.out.println("接收的 json array："+userList.toString());
        return "json 转为 List<User>对象"+userList.toString();
    }


    /**
     * Reader 或 InputStream 读取请求体的数据
     */
    @PostMapping("/param/json2")
    public String getJsonData2(Reader in){
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(in);
            String line =null;
            while ((line = bufferedReader.readLine())!=null){
                content.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "读取请求体数据"+ content.toString();
    }

    /**
     * 测试日期参数
     */
    @GetMapping("/param/date")
    public String paramDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return "日期="+date;
    }

}
