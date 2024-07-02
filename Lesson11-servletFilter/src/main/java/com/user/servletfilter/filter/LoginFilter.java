package com.user.servletfilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("LoginFilter代码执行了，uri="+request.getRequestURI());

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
