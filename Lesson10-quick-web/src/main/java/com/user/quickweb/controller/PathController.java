package com.user.quickweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName PathController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Controller
public class PathController {

    @GetMapping("/file/t?st")
    @ResponseBody
    public String path1(HttpServletRequest request){
        return "path ?请求="+request.getRequestURI();
    }

    @GetMapping("/file/*.gif")
    @ResponseBody
    public String path2(HttpServletRequest request){
        return "* 请求="+request.getRequestURI();
    }

    @GetMapping("/x**z/testValueAnt")
    @ResponseBody
    public String path3(HttpServletRequest request){
        return "** 请求="+request.getRequestURI();
    }

    @GetMapping("/testValueAnt/**")
    @ResponseBody
    public String path4(HttpServletRequest request){
        return "** 请求="+request.getRequestURI();
    }

    @GetMapping("/order/{*id}")
    @ResponseBody
    public String path5(HttpServletRequest request,@PathVariable("id") String id){
        return "/order/{*id} 请求="+request.getRequestURI()+",id="+id;
    }

    @GetMapping("/order/{fileName:\\w+}")
    @ResponseBody
    public String path6(HttpServletRequest request,@PathVariable("fileName") String fileName){
        return "/order/{fileName:\\w+} 请求="+request.getRequestURI()+",fileName="+fileName;
    }




}
