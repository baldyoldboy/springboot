package com.user.pk3;

import org.junit.Test;

/**
 * @ClassName TextBlockTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class TextBlockTest {
    /**
     * 转义字符
     * \ 连接符
     */
    @Test
    public void test05() {
        String s = """
                Spring Boot 是一个快速开发框架\
                基于 “Spring” 框架，创建 Spring 应用\
                内嵌 Web 服务器，以
                jar 或 war 方式运行
                """;
        System.out.println(s);
    }

    /**
     * 文本块的方法
     */
    @Test
    public void test04() {
        String info = """
                Name:%s
                Phone:%d
                Age:%d
                """.formatted("王明",1922212022,23);
        System.out.println(info);
    }

    /**
     * 空白
     * indent()方法
     */
    @Test
    public void test03() {
        String html= """
            <html>
                <body>动力节点，Java 黄埔军校</body>
            </html>
            """;
        System.out.println(html.indent(4));
        System.out.println(html);

    }

    /**
     * 文本块与普通的双引号字符串一样
     */
    @Test
    public void test02() {
        String s1= """
                李四
                王五
                """;
        String s2= """
                李四  
                王五 
                """;
        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1==s2 = " + (s1 == s2));
        System.out.println(s1.substring(0,4));
    }

    /**
     * 认识文本块
     */
    @Test
    public void test01() {
        String s1 = """
                李四
                王五          撒旦
                赵六
                """;
        System.out.println( s1);
    }
}
