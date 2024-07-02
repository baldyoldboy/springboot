package com.user.config.pk6;

import com.user.config.pk5.Security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ApplicationConfig
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Configuration
public class ApplicationConfig {

    @ConfigurationProperties(prefix = "security")
    @Bean
    public Security getSecurity(){
        return new Security();
    }

}
