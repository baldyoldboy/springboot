package com.user.blogadmin.model.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName ArticlePO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Data
public class ArticlePO {
    private  Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
