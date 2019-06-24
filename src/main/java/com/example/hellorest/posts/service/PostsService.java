package com.example.hellorest.posts.service;

import java.util.List;

import com.example.hellorest.posts.model.Post;

public interface PostsService {

	public void save(Post post);

	public List<Post> getAll();

	public Post getOne(long postId);

	public void removeOne(long postId);

	public Post updateOne(long postId, Post post);

}
