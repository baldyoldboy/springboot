package com.user.uploadfile.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName UploadFileController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Controller
public class UploadFileController {

    @GetMapping("/index")
    public String index(){
        return "fileup";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("upfile") MultipartFile multipartFile, HttpServletRequest request) {
        try {
            if (!multipartFile.isEmpty()) {
                System.out.println("multipartFile.getName()=" + multipartFile.getName());
                System.out.println("ContentType = " + multipartFile.getContentType());
                System.out.println("request.getContextPath() = " + request.getContextPath());
                System.out.println("request.getServletPath() = " + request.getServletPath());

                String dirPath = request.getServletContext().getRealPath("/upload");
                File dirFile = new File(dirPath);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }

                //获取原始文件名
                String originalFilename = multipartFile.getOriginalFilename();

                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//.后缀
                String fileName = UUID.randomUUID().toString().replaceAll("-", "");
                String filePath = dirPath+File.separator + fileName + suffix;
                System.out.println("filePath = " + filePath);
                multipartFile.transferTo(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/index.html";
    }

    /**
     * 多文件上传
     */
    @PostMapping("/uploadMulFile")
    public String uploadMulFile(@RequestParam("upfile") MultipartFile[] multipartFiles,HttpServletRequest request){
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                if (!multipartFile.isEmpty()) {
                    System.out.println("multipartFile.getName()=" + multipartFile.getName());
                    System.out.println("ContentType = " + multipartFile.getContentType());
                    System.out.println("request.getContextPath() = " + request.getContextPath());
                    System.out.println("request.getServletPath() = " + request.getServletPath());

                    String dirPath = request.getServletContext().getRealPath("/upload");
                    File dirFile = new File(dirPath);
                    if (!dirFile.exists()) {
                        dirFile.mkdirs();
                    }

                    //获取原始文件名
                    String originalFilename = multipartFile.getOriginalFilename();

                    String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//.后缀
                    String fileName = UUID.randomUUID().toString().replaceAll("-", "");
                    String filePath = dirPath+File.separator + fileName + suffix;
                    System.out.println("filePath = " + filePath);
                    multipartFile.transferTo(new File(filePath));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/index.html";
    }


}
