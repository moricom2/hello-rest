package com.example.hellorest.posts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.hellorest.posts.model.Post;

@Repository("posts.dao.postsDaoInMemory")
public class PostsDaoInMemory implements PostsDao {

	private Map<Long, Post> posts;
	private long postId;

	public PostsDaoInMemory() {
		this.posts = new HashMap<>();
	}

	@Override
	public void insertNewPost(Post post) {
		post.setPostId(++postId);
		posts.put(postId, post);
	}

	@Override
	public List<Post> selectAllPosts() {
		List<Post> result = new ArrayList<>();

		// Map -> List 첫번째 방법
		/*
		 * this.posts.forEach(new BiConsumer<Long, Post>() {
		 * 
		 * @Override public void accept(Long key, Post value) { result.add(value); } });
		 */

		// Map -> List 두번째 방법 (Lambda)
		/*
		 * this.posts.forEach((key, value) -> { result.add(value); });
		 */

		// Map -> List 세번째 방법 (Stream)
		result = this.posts.entrySet().stream().map((entry) -> entry.getValue()).collect(Collectors.toList());

		return result;
	}

	@Override
	public Post selectOnePost(long postId) {
		return this.posts.get(postId);
	}

	@Override
	public void deleteOnePost(long postId) {
		this.posts.remove(postId);
	}

	@Override
	public Post updateOnePost(long postId, Post post) {
		Post originalPost = this.selectOnePost(postId);
		if (post.getSubject().length() > 0) {
			originalPost.setSubject(post.getSubject());
		}
		if (post.getContent().length() > 0) {
			originalPost.setContent(post.getContent());
		}
		return this.posts.put(postId, originalPost);
	}

}
