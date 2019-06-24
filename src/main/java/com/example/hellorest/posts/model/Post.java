package com.example.hellorest.posts.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Post {

	private long postId;

	@NotNull(message = "subject is required")
	@NotEmpty(message = "subject is required")
	private String subject;

	@NotNull(message = "content is required")
	@NotEmpty(message = "content is required")
	// @Length(min = 5, max = 10, message = "content length exceed")
	private String content;

	public Post() {
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post(long postId, String subject, String content) {
		this.postId = postId;
		this.subject = subject;
		this.content = content;
	}
}
