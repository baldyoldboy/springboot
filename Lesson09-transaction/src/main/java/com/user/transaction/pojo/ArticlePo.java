package com.user.transaction.pojo;

import java.time.LocalDateTime;

/**
 * @ClassName ArticlePo
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

public class ArticlePo {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ArticlePo() {
    }


    @Override
    public String toString() {
        return "ArticlePo{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", readCount=" + readCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public ArticlePo(Integer id, Integer userId, String title, String summary, Integer readCount, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.readCount = readCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
