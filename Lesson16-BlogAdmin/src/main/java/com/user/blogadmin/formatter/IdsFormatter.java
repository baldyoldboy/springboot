package com.user.blogadmin.formatter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName IdsFomatter
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class IdsFormatter implements Formatter<Integer[]> {
    @Override
    public Integer[] parse(String text, Locale locale) throws ParseException {
        Integer[] ids = null;
        if (StringUtils.hasText(text)){
            String[] split = text.split("-");
            List<Integer> integerList = new ArrayList<>();
            for (String s : split) {
                integerList.add(Integer.parseInt(s));
            }
            ids = integerList.stream().toArray(Integer[]::new);
        }
        return ids;
    }

    @Override
    public String print(Integer[] object, Locale locale) {
        StringBuilder builder = new StringBuilder(",");
        for (Integer integer : object) {
            builder.append(integer);
        }
        return builder.toString();
    }
}
