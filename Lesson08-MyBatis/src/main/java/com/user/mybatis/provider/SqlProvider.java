package com.user.mybatis.provider;

/**
 * @ClassName SqlProvider
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class SqlProvider {
    public static String selectById(){
        return """
                select id, user_id, title, summary, read_count, create_time, update_time from article
                where id = #{userId}
                """;
    }

    public static String updateTitle(){
        return """
                update article set title = #{title} where id = #{id}
                """;
    }
}
