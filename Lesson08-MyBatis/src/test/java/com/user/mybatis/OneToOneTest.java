package com.user.mybatis;

import com.user.mybatis.mapper.ArticleOneToOneMapper;
import com.user.mybatis.model.ArticlePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName OneToOneTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@SpringBootTest
public class OneToOneTest {
    @Autowired
    private ArticleOneToOneMapper articleOneToOneMapper;

    @Test
    void testArticleOneToOne() {
        ArticlePo articlePo = articleOneToOneMapper.selectArticleById(1);
        System.out.println(articlePo);
    }
}
