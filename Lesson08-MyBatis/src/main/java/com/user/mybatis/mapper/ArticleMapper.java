package com.user.mybatis.mapper;

import com.user.mybatis.model.ArticlePo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleMapper {
    @Insert("""
        insert into article(user_id,title,summary,read_count,create_time,update_time) 
        values (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
    """)
    int insert(ArticlePo articlePo);

    @Select(value = """
            select id, user_id, title, summary, read_count, create_time, update_time
             from spring.article where id = #{id}
            """)
    @Results(id = "BaseArticleMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "title",property = "title"),
            @Result(column = "summary",property = "summary"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    ArticlePo selectArticleById(Integer id);

    @Update("""
    update spring.article set read_count = #{readCount} where id = #{id}
    """)
    int updateArticle(Integer readCount,Integer id);

    @Select("""
    select id, user_id, title, summary, read_count, create_time, update_time from spring.article
    where user_id = #{userID}
    """)
    //@ResultMap("BaseArticleMap")
    @ResultMap("BaseMapper")
    List<ArticlePo> selectListByUserId(Integer userId);

    @Delete("""
    delete from spring.article where id = #{id}
    """)
    int deleteArticleById(Integer id);



}
