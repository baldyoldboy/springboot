package com.user.servletfilter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ArticleController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class ArticleController {
    @PostMapping("/article/add")
    public String addArticle(){
        return "发布新的文章";
    }

    @PostMapping("/article/delete")
    public String deleteArticle(){
        return "删除新的文章";
    }

    @PostMapping("/article/edit")
    public String editArticle(){
        return "编辑新的文章";
    }

    @PostMapping("/article/query")
    public String queryArticle(){
        return "查询新的文章";
    }

}
