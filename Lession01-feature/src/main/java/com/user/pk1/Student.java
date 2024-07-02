package com.user.pk1;

import java.util.Optional;

/**
 *
 * @ClassName Student
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public record Student(Integer id,String name,String email,Integer age) {

    /**
     * 紧凑构造方法
     */
    public Student{
        System.out.println("id = " + id);

        if (id<1000){
            throw new RuntimeException("ok");
        }
    }

    /**
     * 自定义构造方法
     */
    public Student(Integer id,String name){
        this(id,name,null,null);
    }

    /**
     * 静态方法
     * @param email
     * @return
     */
    public static String emailUpperCase(String email){
        return Optional.ofNullable(email).orElse("no Email").toUpperCase();

    }

    /**
     * 实例方法
     * @return
     */
    public String concat(){
       return String.format("姓名：%s,年龄：%d",name,age);
   }
}
