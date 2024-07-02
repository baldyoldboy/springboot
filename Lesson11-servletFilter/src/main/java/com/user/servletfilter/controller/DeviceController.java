package com.user.servletfilter.controller;

import com.user.servletfilter.pojo.DeviceInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DeviceController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class DeviceController {
    @PostMapping("/device/add")
    public String AddDevice(@RequestParam("device") DeviceInfo device){
        return "接收到的设备数据："+device.toString();
    }
}
