package com.user.config.pk7;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



/**
 * @ClassName Group
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "group")
@PropertySource("classpath:/group-info.properties")
public class Group {
    private String name;
    private String leader;
    private Integer member;

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", leader='" + leader + '\'' +
                ", member=" + member +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
}

