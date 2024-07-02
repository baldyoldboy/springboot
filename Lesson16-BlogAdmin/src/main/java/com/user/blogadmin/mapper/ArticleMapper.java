package com.user.blogadmin.mapper;

import com.user.blogadmin.model.po.ArticleAndDetailPO;
import com.user.blogadmin.model.po.ArticleDetailPO;
import com.user.blogadmin.model.po.ArticlePO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleMapper {
    @Select("""
    select id, user_id, title, summary, read_count, create_time, update_time from spring.article
    where read_count >= #{lowRead}
    order by read_count desc
    limit 0, #{topRead}
    """)
    @Results(id = "ArticleBaseMap",value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "title",property = "title"),
            @Result(column = "summary",property = "summary"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    List<ArticlePO> topSortByReadCount(int lowRead,int topRead);


    /**
     * 插入文章
     * @param articlePO
     * @return
     */
    @Insert("""
    insert into spring.article(user_id, title, summary, read_count, create_time, update_time) 
    values (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
    """)
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertArticle(ArticlePO articlePO);

    /**
     * 插入文章细节
     * @param detail
     * @return
     */
    @Insert("""
    insert into spring.article_detail(article_id, content) values 
    (#{articleId},#{content})
    """)
    int insertArticleDetail(ArticleDetailPO detail);

    /**
     * 删除文章细节
     * @param articleIds
     * @return
     */

    @Delete("""
      <script>
        delete from article_detail where article_id in 
        <foreach item="articleId" collection="array" open="(" close=")" separator=",">
            #{articleId}
        </foreach>
      </script>
      """)
    int deleteArticleDetail(Integer[] articleIds);

    /**
     * 删除文章
     * @param ids
     * @return
     */
    @Delete("""
    <script>
        delete from spring.article where id in
        <foreach item="id" collection="array" open="(" close=")" separator=",">
            #{id}
        </foreach>
    </script>
    """)
    int deleteArticle(Integer[] ids);

    /**
     * 根据articleId查询文章细节
     * @param articleId
     * @return
     */
    @Select("""
    select id,article_id,content from article_detail
    where article_id = #{articleId}
    """)
    ArticleDetailPO selectArticleDetailByArticleId(Integer articleId);

    /**
     * 根据id 查询相关的文章信息 和 内容
     * @return
     */
    @Select("""
    select a.id,a.title,a.summary,d.content from article a 
    join article_detail d on a.id = d.article_id
    where a.id = #{id} 
    """)
    ArticleAndDetailPO selectArticleAndDetail(Integer id);


    /**
     * 更新文章
     * @param articlePO
     * @return
     */
    @Update("""
    update article set title = #{title},summary = #{summary},update_time = #{updateTime}
    where id = #{id}
    """)
    int updateArticle(ArticlePO articlePO);

    /**
     * 更新文章细节
     * @param detail
     * @return
     */
    @Update("""
    update article_detail set content = #{content}
    where article_id = #{articleId}
    """)
    int updateArticleDetail(ArticleDetailPO detail);
}
