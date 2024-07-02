package com.user.servletfilter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LoginInterceptor
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> permitUsers = new ArrayList<>();


    public LoginInterceptor() {
        this.permitUsers = Arrays.asList("zhangsan","lisi","wangwu");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=========LoginInterceptor登录拦截器=============");
        String loginUser = request.getParameter("loginUser");
        if (StringUtils.hasText(loginUser) && permitUsers.contains(loginUser)){
            return true;
        }
        return false;
    }
}
