package com.user.servletfilter.servlet;

import com.user.servletfilter.event.StockOutEvent;
import com.user.servletfilter.pojo.Product;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProductService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Service
public class ProductService {

    @Resource
    private ApplicationContext applicationContext ;
    public void update(Product product,Integer num){
        if (product.getNumber()>=num){
            product.setNumber(product.getNumber()-num);
        }else {
            //创建事件
            StockOutEvent stockOutEvent = new StockOutEvent(this, product);
            //发布事件
            applicationContext.publishEvent(stockOutEvent);
            product.setNumber(product.getNumber()-num);
        }


    }
}
