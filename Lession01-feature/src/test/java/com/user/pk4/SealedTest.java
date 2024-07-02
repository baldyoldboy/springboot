package com.user.pk4;

import org.junit.Test;

/**
 * @ClassName SealedTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class SealedTest {

    /**
     * Sealed Classes 主要特点是限制继承，Java 中通过继承增强，扩展了类的能力，
     * 复用某些功能。当这种能力不受控。
     * 与原有类的设计相违背，导致不预见的异常逻辑。
     * 子类声明有三种
     *  final 终结，依然是密封的
     *  sealed 子类是密封类，需要子类实现
     *  non-sealed 非密封类，扩展使用，不受限
     * sealed class 类名 permits 子类 1,子类 N 列表 {}
     */
    @Test
    public void test01() {

    }
}
