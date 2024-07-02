package com.user.blogadmin.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName ArticleSettings
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "article")
public class ArticleSettings {
    private int lowRead;
    private int topRead;
}
