package com.user.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticleDetail
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetail {
    private int id;
    private int articleId;
    private String content;
}
