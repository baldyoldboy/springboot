package com.user.config.pk5;

/**
 * @ClassName Security
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class Security {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Security{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Security() {
    }

    public Security(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
