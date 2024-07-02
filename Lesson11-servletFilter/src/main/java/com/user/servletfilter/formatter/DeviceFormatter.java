package com.user.servletfilter.formatter;

import com.user.servletfilter.pojo.DeviceInfo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

/**
 * @ClassName DeviceFormatter
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class DeviceFormatter implements Formatter<DeviceInfo> {

    //将 String 数据，转为 DeviceInfo
    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {
        DeviceInfo device = null;

        if (StringUtils.hasLength(text)){
            String[] items = text.split(";");
            device = new DeviceInfo(items[0],items[1],items[2],items[3],items[4]);
        }
        return device;
    }

    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringBuilder builder = new StringBuilder("#");
        builder.append(object.getItem1()).append(object.getItem2()).append(object.getItem3()).append(object.getItem4()).append(object.getItem5());
        return builder.toString();
    }
}
