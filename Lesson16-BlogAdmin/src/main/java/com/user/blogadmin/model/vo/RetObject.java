package com.user.blogadmin.model.vo;

import lombok.Data;

/**
 * @ClassName RetObject
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
public class RetObject {
    private Integer code;
    private String message;
    private Object retObj;
}
