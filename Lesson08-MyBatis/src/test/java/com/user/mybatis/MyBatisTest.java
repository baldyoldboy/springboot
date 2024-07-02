package com.user.mybatis;

import com.user.mybatis.mapper.ArticleMapper;
import com.user.mybatis.model.ArticlePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName MyBatisTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@SpringBootTest
public class MyBatisTest {
    /**
     * 测试insert
     */
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void testInsert() {
        ArticlePo articlePo = new ArticlePo(null,2101,"SpringBoot 核心注解",
                "核心注解的主要作用",8976, LocalDateTime.now(),LocalDateTime.now(),null);
        int count = articleMapper.insert(articlePo);
        System.out.println(count);
    }

    /**
     * 测试查询一个
     */
    @Test
    void testSelect() {
        ArticlePo articlePo = articleMapper.selectArticleById(1);
        System.out.println(articlePo);
    }

    /**
     * 测试查询集合
     */
    @Test
    void testSelectList() {
        List<ArticlePo> articlePoList = articleMapper.selectListByUserId(2101);
        articlePoList.forEach(System.out::println);
    }

    /**
     * 测试更新
     */
    @Test
    void testUpdate() {
        int count = articleMapper.updateArticle(9999, 3);
        System.out.println("count = " + count);
    }

    /**
     * 测试删除
     */
    @Test
    void testDelete() {
        int count = articleMapper.deleteArticleById(3);
        System.out.println("count = " + count);
    }
}
