package com.user.transaction.pojo;

/**
 * @ClassName ArticleDetail
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

public class ArticleDetail {
    private int id;
    private int articleId;
    private String content;

    @Override
    public String toString() {
        return "ArticleDetail{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleDetail(int id, int articleId, String content) {
        this.id = id;
        this.articleId = articleId;
        this.content = content;
    }

    public ArticleDetail() {
    }
}
