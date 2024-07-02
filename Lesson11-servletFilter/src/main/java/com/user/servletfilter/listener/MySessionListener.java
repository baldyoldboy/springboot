package com.user.servletfilter.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * @ClassName MySessionListener
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session 创建了");
    }
}
