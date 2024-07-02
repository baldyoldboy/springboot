package com.user.aop.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName SomeServiceImpl
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
public class SomeServiceImpl implements SomeService{
    @Override
    public void query(Integer id) {
        System.out.println("SomeService 业务方法 query 执行了");
    }

    @Override
    public int save(String name, String code) {
        System.out.println("SomeService 业务方法 save 执行了");
        return 0;
    }
}
