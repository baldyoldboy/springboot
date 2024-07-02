package com.user.transaction.service;

import com.user.transaction.pojo.ArticlePo;

/**
 * @ClassName ArticleService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleService {
    boolean postNewArticle(ArticlePo article,String content);
    boolean managerArticle(ArticlePo article,String content);
    boolean managerArticleTransThread(ArticlePo article,String content);
}
