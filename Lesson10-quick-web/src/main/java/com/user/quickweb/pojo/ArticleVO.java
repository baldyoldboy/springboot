package com.user.quickweb.pojo;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * @ClassName ArticleVO
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
public class ArticleVO {

    //新增组
    public static interface AddArticleGroup{};
    //编辑修改组
    public static interface EditArticleGroup{};

    //文章主键
    @NotNull(message = "文章ID不能为空",groups = EditArticleGroup.class)
    @Min(value = 1,message = "文章ID从1开始",groups = EditArticleGroup.class)
    private Integer id;


    @NotNull(message = "必须有作者",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private Integer userId;

    @NotBlank(message = "文章必须有标题",groups = {AddArticleGroup.class,EditArticleGroup.class})
    @Size(min = 3,max = 30,message = "标题必须在3个字以上，30个字以下",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String title;

    @NotBlank(message = "文章必须有副标题",groups = {AddArticleGroup.class,EditArticleGroup.class})
    @Size(min = 8,max = 60,message = "副标题字数必须在8个字以上，60个字以下",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String summary;

    @Min(value = 0,message = "已读最小是0",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private Integer readCount;

    @Email(message = "邮箱格式不对",groups = {AddArticleGroup.class,EditArticleGroup.class})
    private String email;
}
