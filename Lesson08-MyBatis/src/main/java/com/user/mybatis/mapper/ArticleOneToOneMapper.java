package com.user.mybatis.mapper;

import com.user.mybatis.model.ArticleDetail;
import com.user.mybatis.model.ArticlePo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @ClassName ArticleOneToOneMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleOneToOneMapper {
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "article_id",property = "articleId")
    })
    @Select("select id, article_id, content from spring.article_detail where article_id =#{articleId}")
    ArticleDetail selectDetailByArticleId(Integer articleId);


    @Results(value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
            @Result(column = "id",property = "detail",
                one = @One(select = "com.user.mybatis.mapper.ArticleOneToOneMapper.selectDetailByArticleId",fetchType = FetchType.LAZY))
    })
    @Select("""
        select id, user_id, title, summary, read_count, create_time, update_time from spring.article
        where id = #{id}
    """)
    ArticlePo selectArticleById(Integer id);



}
