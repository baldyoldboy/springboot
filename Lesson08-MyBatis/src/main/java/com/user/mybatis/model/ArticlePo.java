package com.user.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName ArticlePo
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePo {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetail detail;
}
