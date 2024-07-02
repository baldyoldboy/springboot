package com.user.jdbctemplate.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName ArticleMainPO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleMainPo {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetail articleDetail;

}
