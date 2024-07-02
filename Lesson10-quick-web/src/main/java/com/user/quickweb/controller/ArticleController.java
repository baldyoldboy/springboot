package com.user.quickweb.controller;

import com.user.quickweb.pojo.ArticleVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class ArticleController {

    //新增文章
    @PostMapping("/article/add")
    public Map<String,Object> addArticle(@Validated(ArticleVO.AddArticleGroup.class) @RequestBody ArticleVO articleVO,
                                         BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if (result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (int i = 0; i <fieldErrors.size() ; i++) {
                FieldError fieldError = fieldErrors.get(i);
                map.put(i+"-"+fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        return map;
    }

    //修改文章
    @PostMapping("/article/edit")
    public Map<String,Object> editArticle(@Validated(ArticleVO.EditArticleGroup.class) @RequestBody ArticleVO articleVO,
                                         BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if (result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (int i = 0; i <fieldErrors.size() ; i++) {
                FieldError fieldError = fieldErrors.get(i);
                map.put(i+"-"+fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        return map;
    }

}
