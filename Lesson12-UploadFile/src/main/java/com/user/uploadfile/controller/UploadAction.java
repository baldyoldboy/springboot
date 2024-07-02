package com.user.uploadfile.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Collection;

/**
 * @ClassName UploadAction
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Controller
public class UploadAction {

    @PostMapping("/files")
    public String uploadFile2(HttpServletRequest request){
        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                String fileName = extractFileName(part);
                part.write(fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/index.html";
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        System.out.println("contentDisposition = " + contentDisposition);
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")){
                return item.substring(item.indexOf("=")+2, item.length()-1);
            }
        }
        return "";
    }

}
