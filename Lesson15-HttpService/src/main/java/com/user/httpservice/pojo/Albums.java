package com.user.httpservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Albums
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Albums {
    private Integer userId;
    private Integer id;
    private String title;
}
