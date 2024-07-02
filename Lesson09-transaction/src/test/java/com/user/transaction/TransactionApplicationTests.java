package com.user.transaction;

import com.user.transaction.pojo.ArticlePo;
import com.user.transaction.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
public class TransactionApplicationTests {

	@Autowired
	private ArticleService articleService;
	@Test
	void testPostNewArticle() {
		System.out.println("===================================");
		System.out.println(articleService.getClass().getName());
		ArticlePo article = new ArticlePo();
		article.setTitle("Spring 事务管理");
		article.setSummary("Spring 事务属性，事务实现");
		article.setUserId(new Random().nextInt(500));
		article.setReadCount(0);
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());
		boolean add = articleService.postNewArticle(article, "Spring 统一事务管理。事务管理器管理本地事务");
		System.out.println(add);
	}

	@Test
	void testManagerArticle() {
		System.out.println("===================================");
		System.out.println(articleService.getClass().getName());
		ArticlePo article = new ArticlePo();
		article.setTitle("Spring 事务管理");
		article.setSummary("Spring 事务属性，事务实现");
		article.setUserId(new Random().nextInt(500));
		article.setReadCount(0);
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());
		boolean add = articleService.managerArticle(article, "Spring 统一事务管理。事务管理器管理本地事务");
		System.out.println(add);
	}

	@Test
	void testManagerArticleTransThread(){
		System.out.println("===================================");
		System.out.println(articleService.getClass().getName());
		ArticlePo article = new ArticlePo();
		article.setTitle("Spring 事务管理");
		article.setSummary("Spring 事务属性，事务实现");
		article.setUserId(new Random().nextInt(500));
		article.setReadCount(0);
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());
		boolean add = articleService.managerArticleTransThread(article, "Spring 统一事务管理。事务管理器管理本地事务");
		System.out.println(add);
	}
}
