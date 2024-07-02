package com.user.jdbctemplate;

import com.user.jdbctemplate.po.ArticleDetail;
import com.user.jdbctemplate.po.ArticleMainPo;
import com.user.jdbctemplate.po.ArticlePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestJdbcTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 测试聚合函数
	 */
	@Test
	void testCount() {
		String sql = "select count(*) as ct from article";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("文章总数 = " + count);
	}

	/**
	 * 测试“?”占位符
	 */
	@Test
	void testQuery() {
		String sql = """
				select * from article where id =?
				""";
		//BeanPropertyRowMapper 将查询结果集，列名与属性名称匹配， 名称完全匹配或驼峰
		ArticlePo articlePo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePo.class), 1);
		System.out.println("查询到的文章 = " + articlePo);

	}

	@Test
	void testQueryRowMapper() {
		String sql = """
				select * from article where id =?
				""";
		ArticlePo articlePo = jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
			int id = rs.getInt("id");
			int userId = rs.getInt("user_id");
			String title = rs.getString("title");
			String summary = rs.getString("summary");
			int readCount = rs.getInt("read_count");
			LocalDateTime createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
			LocalDateTime updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();
			return new ArticlePo(id,userId,title,summary,readCount,createTime,updateTime);
		},1);

		System.out.println(articlePo);
	}

	/**
	 * 测试 List 集合
	 */
	@Test
	void testQueryList() {
		String sql = """
				select * from article
				""";
		List<Map<String,Object>> articlePoList = jdbcTemplate.queryForList(sql);
		articlePoList.forEach(map -> {
			map.forEach((key,value)->{
				System.out.println("键名="+key+"，键值="+value);
			});
			System.out.println("=================================");
		});
	}

	/**
	 * 测试更新
	 */
	@Test
	void testUpdate() {
		String sql = "update article set title=? where id = ?";
		int count = jdbcTemplate.update(sql, "java EE框架技术", 1);
		System.out.println(count);
	}

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 测试使用命名参数
	 */
	@Test
	public void testNameQuery() {
		String sql="select * from article where title = :name ";
		Map<String,Object> map = new HashMap<>();
		map.put("name", "java EE框架技术");
		ArticlePo articlePo = template.queryForObject(sql, map, new BeanPropertyRowMapper<>(ArticlePo.class));
		System.out.println("articlePo = " + articlePo);

	}

	@Test
	void testArticleContent() {
		String sql = """
				select a.*,d.id as detail_id ,d.article_id,d.content
				from article a
				join article_detail d
				on a.id = d.article_id
				where a.id = :id
				""";
		Map<String,Object> param = new HashMap<>();
		param.put("id", 1);

		List<ArticleMainPo> list =  template.query(sql,param,(rs,rowNum)->{
			//获取article的参数
			int id = rs.getInt("id");
			int userId = rs.getInt("user_id");
			String title = rs.getString("title");
			String summary = rs.getString("summary");
			int readCount = rs.getInt("read_count");
			LocalDateTime createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
			LocalDateTime updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();
			//获取articleDetail的参数
			var detailId = rs.getInt("detail_id");
			var articleId = rs.getInt("article_id");
			var content = rs.getString("content");
			ArticleDetail detail = new ArticleDetail(detailId, articleId, content);
			return new ArticleMainPo(id, userId, title, summary, readCount, createTime, updateTime, detail);
		});

		list.forEach(System.out::println);

	}
}
