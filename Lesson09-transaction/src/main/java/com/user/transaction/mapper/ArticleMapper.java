package com.user.transaction.mapper;

import com.user.transaction.pojo.ArticleDetail;
import com.user.transaction.pojo.ArticlePo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleMapper {
    @Insert("""
    insert into spring.article(user_id,title,summary,read_count,create_time,update_time) values
     (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
    """)
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertArticle(ArticlePo articlePo);

    @Insert("""
    insert into spring.article_detail(article_id, content) values (#{articleId},#{content})
    """)
    int insertArticleDetail(ArticleDetail articleDetail);
}
