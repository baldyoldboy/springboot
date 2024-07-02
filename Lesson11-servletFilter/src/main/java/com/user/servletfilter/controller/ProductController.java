package com.user.servletfilter.controller;

import com.user.servletfilter.pojo.Product;
import com.user.servletfilter.servlet.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class ProductController {

    private static Product product = new Product("手机",20);

    @Autowired
    private ProductService productService;

    @GetMapping("/product/buy")
    public Product buyProduct(int num){
        productService.update(product,num);
        return product;
    }
}
