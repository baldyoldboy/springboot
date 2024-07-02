package com.user.blogadmin.model.dto;

import lombok.Data;

/**
 * @ClassName ArticleDTO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
public class ArticleDTO {
    private Integer id;
    private String title;
    private String summary;
    private String content;
}
