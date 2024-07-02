package com.user.blogadmin.settings;

import com.user.blogadmin.formatter.IdsFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebSetting
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Configuration
public class WebSetting implements WebMvcConfigurer {

    /**
     * 格式转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new IdsFormatter());
    }
}
