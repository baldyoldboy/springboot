package com.user.servletfilter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName AuthInterceptor
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class AuthInterceptor implements HandlerInterceptor {
    private final String COMMON_USER = "zhangsan";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("============AuthInterceptor权限拦截器==============");
        //获取登录的用户
        String loginUser = request.getParameter("loginUser");
        //获取请求的uri
        String uri = request.getRequestURI();
        if (loginUser.equals(COMMON_USER)){
            if (uri.startsWith("/article/add")||uri.startsWith("/article/delete")||
            uri.startsWith("/article/edit")) {
                return false;
            }
        }

        return true;
    }
}
