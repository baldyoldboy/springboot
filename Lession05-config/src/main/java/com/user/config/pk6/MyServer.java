package com.user.config.pk6;

/**
 * @ClassName MyServer
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class MyServer {
    private String title;
    private String ip;


    @Override
    public String toString() {
        return "MyServer{" +
                "title='" + title + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
