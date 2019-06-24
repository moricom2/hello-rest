package com.example.hellorest.posts.dao;

import java.util.List;

import com.example.hellorest.posts.model.Post;

public interface PostsDao {

	public void insertNewPost(Post post);

	public List<Post> selectAllPosts();

	public Post selectOnePost(long postId);

	public void deleteOnePost(long postId);

	public Post updateOnePost(long postId, Post post);

}
