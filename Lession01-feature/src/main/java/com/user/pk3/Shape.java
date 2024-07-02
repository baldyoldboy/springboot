package com.user.pk3;

/**
 * @ClassName Shape
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public sealed class Shape permits Circle,Square,Rectangle{
    private Integer width;
    private Integer Height;

    public void draw(){
        System.out.println("=====Shape 图形======");
    }
}
