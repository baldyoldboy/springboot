package com.user.blogadmin.model.po;

import lombok.Data;

/**
 * @ClassName ArticleDetailPO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Data
public class ArticleDetailPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
