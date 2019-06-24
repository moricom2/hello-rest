package com.example.hellorest.posts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.hellorest.posts.model.Post;

@Repository("posts.dao.postsDaoH2")
public class PostsDaoH2 implements PostsDao {

	private Logger logger = LoggerFactory.getLogger(PostsDaoH2.class);

	@Autowired
	public JdbcTemplate jdbcTemplate;

/*CREATE TABLE POST (
 POST_ID INT AUTO_INCREMENT PRIMARY KEY,
 SUBJECT VARCHAR(255),
 CONTENT VARCHAR(500)
);

CREATE TABLE MEMBER (
 MEMBER_ID INT AUTO_INCREMENT PRIMARY KEY,
 NAME VARCHAR(100),
 USERNAME VARCHAR(100)
);*/

	@Override
	public void insertNewPost(Post post) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO POST (SUBJECT, CONTENT) ");
		sql.append(" VALUES (?, ?) ");

		int resultCount = jdbcTemplate.update(sql.toString(), post.getSubject(), post.getContent());
		logger.debug("insertNewPost Result Count : " + resultCount);
	}

	@Override
	public List<Post> selectAllPosts() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT POST_ID, SUBJECT, CONTENT ");
		sql.append(" FROM POST ");

		List<Post> resultList = jdbcTemplate.query(sql.toString(), new RowMapper<Post>() {

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setPostId(rs.getInt("POST_ID"));
				post.setSubject(rs.getString("SUBJECT"));
				post.setContent(rs.getString("CONTENT"));

				return post;
			}
		});

		return resultList;
	}

	@Override
	public Post selectOnePost(long postId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT POST_ID, SUBJECT, CONTENT ");
		sql.append(" FROM POST ");
		sql.append(" WHERE POST_ID = ? ");

		return jdbcTemplate.queryForObject(sql.toString(), new Object[] { postId }, (rs, rowNum) -> {
			Post post = new Post();
			post.setPostId(rs.getInt(1));
			post.setSubject(rs.getString(2));
			post.setContent(rs.getString(3));
			return post;
		});
	}

	@Override
	public void deleteOnePost(long postId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM POST ");
		sql.append(" WHERE POST_ID = ? ");

		int resultCount = jdbcTemplate.update(sql.toString(), postId);
		logger.debug("deleteOnePost Result Count" + resultCount);
	}

	@Override
	public Post updateOnePost(long postId, Post post) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE POST ");
		sql.append(" SET SUBJECT = ?, CONTENT = ? ");
		sql.append(" WHERE POST_ID = ? ");

		int resultCount = jdbcTemplate.update(sql.toString(), post.getSubject(), post.getContent(), postId);
		logger.debug("updateOnePost Result Count : " + resultCount);

		return this.selectOnePost(postId);
	}

}
