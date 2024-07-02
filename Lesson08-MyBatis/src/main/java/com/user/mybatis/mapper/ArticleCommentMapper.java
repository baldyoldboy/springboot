package com.user.mybatis.mapper;

import com.user.mybatis.model.ArticleEntity;
import com.user.mybatis.model.CommentPO;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName ArticleCommentMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleCommentMapper {
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "article_id",property = "articleId")
    })
    @Select("select id, article_id, content from spring.comment where article_id = #{articleId}")
    List<CommentPO> selectCommentListByArticleId(Integer articleId);

    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id",property = "comments",
            many = @Many(select = "com.user.mybatis.mapper.ArticleCommentMapper.selectCommentListByArticleId",fetchType = FetchType.LAZY))
    })
    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time
           from spring.article where id = #{id}
       """)
    ArticleEntity selectArticleEntityById(Integer id);
}
