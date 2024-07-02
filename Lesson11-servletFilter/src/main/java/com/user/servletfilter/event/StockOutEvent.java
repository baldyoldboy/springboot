package com.user.servletfilter.event;

import com.user.servletfilter.pojo.Product;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @ClassName stockoutEvent
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

public class StockOutEvent extends ApplicationEvent {
    private Product product;

    public StockOutEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }

    public StockOutEvent(Object source, Clock clock, Product product) {
        super(source, clock);
        this.product = product;
    }

    public StockOutEvent(Object source) {
        super(source);
    }

    public StockOutEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
