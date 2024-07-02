package com.user.blogadmin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.user.blogadmin.model.dto.ArticleDTO;
import com.user.blogadmin.model.param.ArticleParam;
import com.user.blogadmin.model.po.ArticlePO;
import com.user.blogadmin.model.vo.ArticleVO;
import com.user.blogadmin.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ArticleController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    /**
     * 去往文章列表页
     * @return
     */
    @GetMapping({"/","/article/list"})
    public String toListPage(Model model){
        //查询前十篇文章
        List<ArticlePO> articlePOList = articleService.queryTopSortByReadCount();
        //将PO 转位 VO
        List<ArticleVO> articleVOList = BeanUtil.copyToList(articlePOList,ArticleVO.class);
        //放入域中
        model.addAttribute("articleList", articleVOList);
        return "articleList";
    }

    /**
     * 发布文章
     * @param articleParam
     * @return
     */
    @PostMapping("/article/add")
    public String add(@Validated(ArticleParam.AddArticleGroup.class) ArticleParam articleParam){
        //封装articleDTO对象
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(articleParam.getTitle());
        articleDTO.setSummary(articleParam.getSummary());
        articleDTO.setContent(articleParam.getContent());
        articleService.addArticleAndDetail(articleDTO);
        return "redirect:/article/list";
    }

    /**
     * 删除文章
     * @param ids
     * @return
     */
    @GetMapping("/article/delete")
    public String delete( Integer[] ids){
        //删除
        articleService.removeArticleAndDetail(ids);
        return "redirect:/article/list";
    }

    /**
     * 略览文章内容前20个字
     */
    @GetMapping(value = "/article/glance",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String glance(Integer id){
        return articleService.showGlanceArticle(id);
    }


    @GetMapping("/article/edit")
    public String editArticle(Integer id,Model model){
        ArticleDTO articleDTO = articleService.selectArticleAndDetail(id);
        //将DTO 转为 VO
        ArticleVO articleVO = BeanUtil.copyProperties(articleDTO, ArticleVO.class);
        model.addAttribute("article",articleVO);

        return "editArticle";
    }

    @PostMapping("/article/edit")
    public String saveEditArticle(@Validated(ArticleParam.EditArticleGroup.class) ArticleParam articleParam){
        //更新文章
        //将 param 转为 dto
        ArticleDTO articleDTO = BeanUtil.copyProperties(articleParam, ArticleDTO.class);
        //更新文章细节
        boolean flag = articleService.saveEditArticle(articleDTO);
        if (flag){
            return "redirect:/article/list";
        }else {
            new RuntimeException("更新失败,请稍后重试");
        }
        return "redirect:/article/list";
    }

}
