package com.user.servletfilter.pojo;

import lombok.Data;

/**
 * @ClassName ArticleVO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
public class ArticleVO {

    private Integer id;

    private Integer userId;

    private String title;

    private String summary;

    private Integer readCount;

    private String email;
}
