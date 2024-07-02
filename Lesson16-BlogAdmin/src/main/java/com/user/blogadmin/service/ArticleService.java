package com.user.blogadmin.service;

import com.user.blogadmin.model.dto.ArticleDTO;
import com.user.blogadmin.model.po.ArticlePO;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface ArticleService {

    /**
     * 查询符合readCount要求的前topRead的文章集合
     * @return
     */
    List<ArticlePO> queryTopSortByReadCount();

    /**
     * 发布文章
     * 添加article 和 detail
     * @param articleDTO
     * @return
     */
    boolean addArticleAndDetail(ArticleDTO articleDTO);

    /**
     * 删除文章
     * @param ids
     * @return
     */
    boolean removeArticleAndDetail(Integer[] ids);

    /**
     * 略览文章
     * @return
     */
    String showGlanceArticle(Integer articleId);

    /**
     * 编辑文章第一步 根据id查询到文章相关信息
     */
    ArticleDTO selectArticleAndDetail(Integer id);

    /**
     * 编辑文章第二步 根据id更新文章相关信息
     */
    boolean saveEditArticle(ArticleDTO articleDTO);

}
