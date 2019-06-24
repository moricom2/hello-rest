package com.example.hellorest.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.hellorest.posts.dao.PostsDao;
import com.example.hellorest.posts.model.Post;

@Service
public class PostsServiceImpl implements PostsService {

	@Autowired
	@Qualifier("posts.dao.postsDaoInMemory")
	private PostsDao postDao;

	@Override
	public void save(Post post) {
		postDao.insertNewPost(post);
	}

	@Override
	public List<Post> getAll() {
		return postDao.selectAllPosts();
	}

	@Override
	public Post getOne(long postId) {
		return postDao.selectOnePost(postId);
	}

	@Override
	public void removeOne(long postId) {
		postDao.deleteOnePost(postId);
	}

	@Override
	public Post updateOne(long postId, Post post) {
		return postDao.updateOnePost(postId, post);
	}

}
