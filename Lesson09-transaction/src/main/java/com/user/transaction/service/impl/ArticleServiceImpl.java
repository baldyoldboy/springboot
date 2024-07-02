package com.user.transaction.service.impl;

import com.user.transaction.mapper.ArticleMapper;
import com.user.transaction.pojo.ArticleDetail;
import com.user.transaction.pojo.ArticlePo;
import com.user.transaction.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ArticleServiceImpl
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    @Transactional
    public boolean postNewArticle(ArticlePo article, String content) {
        //新增文章
        int count = articleMapper.insertArticle(article);

        //制造异常
        if (article.getReadCount()<1){
            throw new RuntimeException("阅读时长不能少于1");
        }

        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleId(article.getId());
        articleDetail.setContent(content);
        //新增文章内容
        count +=articleMapper.insertArticleDetail(articleDetail);

        if(count == 2){
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean managerArticle(ArticlePo article, String content) {
        postNewArticle(article,content);
        return true;
    }

    @Override
    @Transactional
    public boolean managerArticleTransThread(ArticlePo article, String content) {
        System.out.println("start 父线程："+Thread.currentThread().getName());

        Thread thread = new Thread(()->{
            System.out.println("子线程：" + Thread.currentThread().getName());
            this.articleMapper.insertArticle(article);
            if (article.getReadCount() < 1) {
                throw new RuntimeException("====文章阅读数量最小为1====");
            } else {
                ArticleDetail articleDetail = new ArticleDetail();
                articleDetail.setArticleId(article.getId());
                articleDetail.setContent(content);
                articleMapper.insertArticleDetail(articleDetail);
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end 父线程："+Thread.currentThread().getName());
        return false;
    }

}
