package com.user.mybatis;

import com.user.mybatis.mapper.ArticleProviderMapper;
import com.user.mybatis.model.ArticlePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName SqlProviderTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@SpringBootTest
public class SqlProviderTest {
    @Autowired
    private ArticleProviderMapper articleProviderMapper;

    @Test
    void testSelectOne() {
        ArticlePo articlePo = articleProviderMapper.selectArticleById(1);
        System.out.println("articlePo = " + articlePo);
    }

    @Test
    void testUpdate() {
        int count = articleProviderMapper.updateTitle("很好撒旦", 1);
        System.out.println("count = " + count);
    }
}
