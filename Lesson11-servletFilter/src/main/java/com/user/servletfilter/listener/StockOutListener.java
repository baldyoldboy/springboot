package com.user.servletfilter.listener;

import com.user.servletfilter.event.StockOutEvent;
import com.user.servletfilter.pojo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName stockOutListener
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Component
public class StockOutListener implements ApplicationListener<StockOutEvent> {
    private Logger logger = LoggerFactory.getLogger(StockOutListener.class);

    @Override
    public void onApplicationEvent(StockOutEvent event) {
        Product product = event.getProduct();
        logger.info("==========我要做缺货处理后的后续处理了=========");
        logger.info("给缺货物品数量+10");
        product.setNumber(product.getNumber()+10);
    }
}
