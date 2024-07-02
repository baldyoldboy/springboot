package com.user.httpservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Todo
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}
