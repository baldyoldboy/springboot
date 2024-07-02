package com.user.exceptionhandler.controller;

import com.user.exceptionhandler.vo.OrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class OrderController {

    @PostMapping("/order/new")
    public String createOrder(@Validated @RequestBody OrderVO orderVO){
        return "订单信息："+orderVO.toString();
    }

}
