package com.user.config;

import com.user.config.pk2.ReadConfig;
import com.user.config.pk1.SomeService;
import com.user.config.pk3.MultiConfigService;
import com.user.config.pk4.MultiEnvService;
import com.user.config.pk5.AppBean;
import com.user.config.pk5.Security;
import com.user.config.pk6.CollectionConfig;
import com.user.config.pk7.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson05ConfigApplicationTests {

    /**
     * 测试指定数据源文件
     *   @ Configuration+ @ConfigurationProperties+@PropertySource
     */
    @Autowired
    private Group group;
    @Test
    void test09() {
        System.out.println("group = " + group);
    }

    /**
     * 测试 集合Map，List以及Array
     */
    @Autowired
    private CollectionConfig collectionConfig;
    @Test
    void test08() {
        System.out.println("collectionConfig = " + collectionConfig);
    }

    /**
     * 测试处理第三方库对象 赋值
     */
    @Autowired
    private Security security;
    @Test
    void test07() {
        System.out.println(security);
    }

    /**
     * 测试嵌套Bean
     * 与@EnableConfigurationPropeties
     * 与@ConfigurationPropetiesScan
     */
    @Test
    void test06() {
        System.out.println(appBean);
        System.out.println(appBean.getSecurity());
    }

    /**
     * 测试 @ConfigurationProperties
     */

    @Autowired
    private AppBean appBean;
    @Test
    void test05() {
        System.out.println("appBean = " + appBean);
        System.out.println(appBean);
    }

    /**
     * 测试 多环境配置
     */
    @Autowired
    private MultiEnvService multiEnvService;
    @Test
    void test04() {
        multiEnvService.print();
    }

    /**
     * 测试 组织多文件
     */
    @Autowired
    private MultiConfigService multiConfigService;
    @Test
    void test03() {
        multiConfigService.printValue();
    }

    /**
     * 测试 Environment
     */
    @Autowired
    private ReadConfig readConfig;
    @Test
    void test02() {
        System.out.println(readConfig);
        readConfig.print();
    }

    /**
     * 测试 @Value
     */
    @Autowired
    private SomeService someService;
    @Test
    void test01() {
        someService.printValue();
    }
}
