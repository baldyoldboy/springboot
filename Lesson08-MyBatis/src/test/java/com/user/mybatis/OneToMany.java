package com.user.mybatis;

import com.user.mybatis.mapper.ArticleCommentMapper;
import com.user.mybatis.model.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName OneToMany
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@SpringBootTest
public class OneToMany {
    @Autowired
    private ArticleCommentMapper mapper;
    @Test
    void testOneToMany() {
        ArticleEntity articleEntity = mapper.selectArticleEntityById(1);
        System.out.println(articleEntity);
    }
}
