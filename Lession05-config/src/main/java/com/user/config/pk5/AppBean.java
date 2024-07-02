package com.user.config.pk5;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName AppBean
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@ConfigurationProperties(prefix = "app")
public class AppBean {
    private String name;
    private String owner;
    private Integer ports;
    private Security security;




    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPorts() {
        return ports;
    }

    public void setPorts(Integer ports) {
        this.ports = ports;
    }
}
