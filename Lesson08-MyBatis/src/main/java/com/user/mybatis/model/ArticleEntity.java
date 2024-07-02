package com.user.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName ArticleEntity
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    List<CommentPO> comments;
}
