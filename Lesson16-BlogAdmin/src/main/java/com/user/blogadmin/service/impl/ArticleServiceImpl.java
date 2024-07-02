package com.user.blogadmin.service.impl;

import com.user.blogadmin.mapper.ArticleMapper;
import com.user.blogadmin.model.dto.ArticleDTO;
import com.user.blogadmin.model.po.ArticleAndDetailPO;
import com.user.blogadmin.model.po.ArticleDetailPO;
import com.user.blogadmin.model.po.ArticlePO;
import com.user.blogadmin.service.ArticleService;
import com.user.blogadmin.settings.ArticleSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @ClassName ArticleServiceImpl
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    private final ArticleSettings articleSettings;

    @Override
    public List<ArticlePO> queryTopSortByReadCount() {
        return articleMapper.topSortByReadCount(articleSettings.getLowRead(), articleSettings.getTopRead());
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean addArticleAndDetail(ArticleDTO articleDTO) {
        //封装文章
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUserId(new Random().nextInt(2000));
        articlePO.setTitle(articleDTO.getTitle());
        articlePO.setSummary(articleDTO.getSummary());
        articlePO.setReadCount(new Random().nextInt(3000));
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());
        int count = articleMapper.insertArticle(articlePO);

        //封装文章细节
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articlePO.getId());
        articleDetailPO.setContent(articleDTO.getContent());
        count += articleMapper.insertArticleDetail(articleDetailPO);

        return count == 2;
    }


    @Override
    @Transactional
    public boolean removeArticleAndDetail(Integer[] ids) {
        //删除文章细节
        int count = articleMapper.deleteArticleDetail(ids);

        //删除文章
        count +=articleMapper.deleteArticle(ids);
        return count == 2;
    }


    @Override
    public String showGlanceArticle(Integer articleId) {
        ArticleDetailPO articleDetailPO = articleMapper.selectArticleDetailByArticleId(articleId);
        //返回文章内容前20个字
        String glanceContent = articleDetailPO.getContent().substring(0,20);
        return glanceContent+"......";
    }

    @Override
    public ArticleDTO selectArticleAndDetail(Integer id) {
        ArticleAndDetailPO articleAndDetail = articleMapper.selectArticleAndDetail(id);
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(articleAndDetail.getId());
        articleDTO.setTitle(articleAndDetail.getTitle());
        articleDTO.setSummary(articleAndDetail.getSummary());
        articleDTO.setContent(articleAndDetail.getContent());

        return articleDTO;
    }

    @Override
    public boolean saveEditArticle(ArticleDTO articleDTO) {
        //封装文章
        ArticlePO articlePO = new ArticlePO();
        articlePO.setId(articleDTO.getId());
        articlePO.setTitle(articleDTO.getTitle());
        articlePO.setSummary(articleDTO.getSummary());
        articlePO.setUpdateTime(LocalDateTime.now());
        int count = articleMapper.updateArticle(articlePO);

        //封装文章细节
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articlePO.getId());
        articleDetailPO.setContent(articleDTO.getContent());

        count  += articleMapper.updateArticleDetail(articleDetailPO);
        return count == 2;
    }
}
