package com.user.blogadmin.model.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName ArticleParam
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Data
public class ArticleParam {
    public interface AddArticleGroup{};
    public interface EditArticleGroup{};

    @NotNull(message = "修改时必须有id",groups = EditArticleGroup.class)
    @Min(value = 1,message = "文章id大于{value}",groups = EditArticleGroup.class)
    private Integer id;

    @NotBlank(message = "请输入文章标题",groups = {AddArticleGroup.class,EditArticleGroup.class})
    @Size(min = 2,max = 20,message = "文章标题字数在{min}-{max}之间",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String title;

    @NotBlank(message = "请输入副标题",groups = {AddArticleGroup.class,EditArticleGroup.class})
    @Size(min = 10,max = 30,message = "副标题字数在{min}-{max}之间",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String summary;

    @NotBlank(message = "请输入文章内容",groups = {AddArticleGroup.class,EditArticleGroup.class})
    @Size(min = 20,max = 3000,message = "文章内容字数在{min}-{max}之间",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String content;
}
