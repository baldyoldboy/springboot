package com.user.mybatis.mapper;

import com.user.mybatis.model.ArticlePo;
import com.user.mybatis.provider.SqlProvider;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName ArticleProviderMapper
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleProviderMapper {

    @Select("")
    @Results(id = "BaseMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    ArticlePo articleMapper();

    @SelectProvider(value = SqlProvider.class,method = "selectById")
    @ResultMap("BaseMapper")
    ArticlePo selectArticleById(Integer id);

    @UpdateProvider(value = SqlProvider.class,method = "updateTitle")
    int updateTitle(String title,Integer id);
}
