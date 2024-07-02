package com.user.servletfilter.config;

import com.user.servletfilter.filter.AuthFilter;
import com.user.servletfilter.filter.LoginFilter;
import com.user.servletfilter.listener.MySessionListener;
import com.user.servletfilter.servlet.LoginServlet;
import jakarta.servlet.Filter;
import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.EventListener;

/**
 * @ClassName WebAppConfig
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Configuration
public class WebAppConfig {
    @Bean
    public ServletRegistrationBean addServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new LoginServlet());
        servletServletRegistrationBean.addUrlMappings("/user/login");
        servletServletRegistrationBean.setLoadOnStartup(1);

        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean addAuthFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean addLoginFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean addOtherFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        //创建Filter对象
        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
        //包含请求的uri
        commonsRequestLoggingFilter.setIncludeQueryString(true);
        //登记Filter
        filterRegistrationBean.setFilter(commonsRequestLoggingFilter);
        //拦截所有的地址
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean addListener(){
        ServletListenerRegistrationBean<EventListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setListener(new MySessionListener());

        return listenerRegistrationBean;
    }
}
