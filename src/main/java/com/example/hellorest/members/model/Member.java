package com.example.hellorest.members.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Member {

	private long id;

	@NotNull(message = "name is required")
	@NotEmpty(message = "name is required")
	private String name;

	@NotNull(message = "username is required")
	@NotEmpty(message = "username is required")
	private String username;

	public Member() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Member(long id, String name, String username) {
		this.id = id;
		this.name = name;
		this.username = username;
	}

}
