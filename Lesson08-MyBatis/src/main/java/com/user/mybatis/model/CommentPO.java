package com.user.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommentPO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
