package com.user.pk1;

import org.junit.Test;

import java.lang.reflect.RecordComponent;
import java.util.Optional;

public class RecordTest {
    /**
     * 测试
     * java.lang.Class 类与 Record 类有关的两个方法：
     * boolean isRecord() : 判断一个类是否是 Record 类型
     * RecordComponent[] getRecordComponents()：Record 的数组，表示此记录类的所有记录组件
     */

    @Test
    public void test09() {
        PeoPle people = new PeoPle("王明", 33);
        boolean record = people.getClass().isRecord();
        System.out.println("record = " + record);

        RecordComponent[] recordComponents = people.getClass().getRecordComponents();
        for (RecordComponent recordComponent : recordComponents) {
            System.out.println("recordComponent = " + recordComponent);
        }
    }

    /**
     * 测试instanceof 判断 Record 类型
     */
    @Test
    public void test08() {
        SomeService someService = new SomeService();
    //    System.out.println(someService.isAdult(new PeoPle("李四", 19)));
        System.out.println(someService.isAdult(null));
    }

    /**
     * 测试嵌套Record
     */
    @Test
    public void test07() {
        Address address = new Address("九江共青城", "茶山街道", "12232");
        PhoneNumber phone = new PhoneNumber("033", "3211231");
        Customer customer = new Customer("张三", address, phone);
        System.out.println("customer = " + customer);
    }

    /**
     * 测试 Record 可以局部对象使用
     */
    @Test
    public void test06() {
        //定义Java Record
        record SaleRecord(String saleId,String saleName,Double saleMoney){}

        //创建Local Record
        SaleRecord saleRecord = new SaleRecord("P1002", "电脑", 6999.0);
        System.out.println("saleRecord = " + saleRecord);
    }

    /**
     * 测试Record实现接口
     */
    @Test
    public void test05() {
        ProductRecord productRecord = new ProductRecord("P001", "手机", 1000);
        productRecord.printf();
    }

    /**
     * 测试紧凑构造方法 和 自定义构造方法
     */
    @Test
    public void test04() {
        Student student = new Student(1002, "张三");
        System.out.println("student = " + student);
    }

    /**
     * 测试Optional方法
     */
    @Test
    public void testOptional() {
        Person p = new Person("张三","22");
        Optional<Person> optional = Optional.ofNullable(p);
        //如果存在，则干点啥
        optional.map(Person::getName).ifPresent(System.out::println);

        //orElse 和 orElseGet方法的区别 orElse()方法获取Optional对象中的值或默认值，
        //不管optional是否为空，都会执行callOther() 非懒汉算法
        Person person1 = optional.orElse(callOther());
        System.out.println("person1 = " + person1);

        Person person2 = optional.orElseGet(this::callOther);
        System.out.println("person2 = " + person2);

        //map和flatMap的区别
        //会拆包
        Optional<String> p1 = optional.flatMap(person -> getPersonName(person));

        Optional<Optional<String>> p2 = optional.map(person -> getPersonName(person));

    }

    public Person callOther(){
        System.out.println("callOther 方法执行了");
        return new Person();
    }

    public Optional<String> getPersonName(Person person){
        return Optional.ofNullable(person).map(Person::getName);
    }

    /**
     * 测试静态方法
     */
    @Test
    public void test03() {
        Student zhaoliu = new Student(1004, "赵六", "zhaoliu@qq.com", 24);
        System.out.println("email = " + Student.emailUpperCase(null));
    }

    /**
     * 测试实例方法
     */
    @Test
    public void test02() {
        var wangwu = new Student(1003, "王五", "wangwu@qq.com", 21);
        System.out.println("wangwu.concat() = " + wangwu.concat());
    }

    @Test
    public void test01() {
        //创建Record对象
        Student zhangsan = new Student(1001, "张三", "zhangsan@qq.com", 20);
        System.out.println("zhangsan = " + zhangsan.toString());
        System.out.println("zhangsan.name() = " + zhangsan.name());
        Student lisi = new Student(1002, "李四", "lisi@qq.com", 23);
        System.out.println("lisi = " + lisi);
        System.out.println("zhangsan.equals(lisi) = " + zhangsan.equals(lisi));
        System.out.println("lisi.name() = " + lisi.name());

    }
}