package com.user.servletfilter.config;

import com.user.servletfilter.formatter.DeviceFormatter;
import com.user.servletfilter.interceptor.AuthInterceptor;
import com.user.servletfilter.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebSetting
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Configuration
public class WebSetting implements WebMvcConfigurer {
    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/welcome").setViewName("index");
    }

    //格式转换器
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    //增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //权限拦截器
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/article/**")
                .order(2)
                .excludePathPatterns("/article/query");
        //登入拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有的请求
                .order(1)
                .excludePathPatterns("/article/query");
    }
}
