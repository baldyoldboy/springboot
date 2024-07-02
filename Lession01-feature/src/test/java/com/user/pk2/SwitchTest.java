package com.user.pk2;

import org.junit.Test;

/**
 * @ClassName SwitchTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class SwitchTest {
    /**
     * switch 表达式中使用 record，结合 case 标签-> 表达式，yield 实现复杂的计算
     */
    @Test
    public void test05() {
        Line line = new Line(5, 10);
        Rectangle rectangle = new Rectangle(30, 40);
        Shape shape = new Shape(20, 20);
        Object object = rectangle;


    }

    /**
     * case 标签-> 与 case 标签：不能混用。
     * 一个 switch 语句块中使用一种语法格式。
     * switch 作为表达式，赋值给变量，需要 yield 或者 case 标签-> 表达式。
     * ->右侧表达式为 case 返回值
     */
    @Test
    public void test04() {
       int week=3;
       String memo = switch (week){
           case 1->"休息";
           case 2,3,4,5,6->"工作";
           case 7->"休息";
           default -> "无效日期";
       };
        System.out.println("memo = " + memo);
    }

    /**
     * 多表达式， case 与 yield 结合使用
     * 使用yield 要考虑switch所有的情况
     */
    @Test
    public void test03() {
        int week = 1;
        String memo = switch (week){
            case 1->{
                System.out.println("week = 1 的表达式部分");
                yield "星期天，休息";
            }
            case 2,3,4,5,6->{
                System.out.println("week = 2,3,4,5,6 的表达式部分");
                yield "工作日";
            }
            case 7->{
                System.out.println("week = 7 的表达式部分");
                yield "星期六，休息";
            }
            default -> {
                System.out.println("其他语句");
                yield "无效的日期";
            }
        };
        System.out.println("memo = " + memo);

    }

    /**
     * yield 返回值
     */
    @Test
    public void test02() {
        int week = 2;
        String memo = switch (week){
            case 1:yield "星期天，休息";
            case 2,3,4,5,6:yield "工作日";
            case 7:yield "星期六，休息";
            default:yield "无效的日期";
        };
        System.out.println("memo = " + memo);
    }

    /**
     * 测试箭头表达式
     */
    @Test
    public void test01() {
        int week = 1;
        String memo="";
        switch (week){
            case 1->memo="星期天，休息日";
            case 2,3,4,5,6->memo="工作日";
            case 7->memo="星期六，休息日";
            default->throw new  RuntimeException("无效的日期");
        }
        System.out.println("memo = " + memo);

    }

    /**
     * 普通的switch表达式
     */
    @Test
    public void test0() {
        int week=4;
        String memo="";
        switch (week){
            case 1:memo="星期天，休息日";
                break;
            case 2,3,4,5,6: memo="工作日";
                break;
            case 7:memo="星期六,休息日";
                break;
            //default:throw new RuntimeException("无效的日期");
        }
        System.out.println("memo = " + memo);
    }
}
