package com.example.hellorest.posts.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellorest.exceptions.ApiException;
import com.example.hellorest.posts.model.Post;
import com.example.hellorest.posts.service.PostsService;
import com.example.hellorest.response.ApiDataResponse;
import com.example.hellorest.response.ApiResponse;

@RestController
public class PostsApiController {

	@Autowired
	private PostsService postsService;

	/**
	 * @URI /posts
	 * @Method POST
	 * @Request { "subject" : "Post Subject", "content" : "Post Content" }
	 * @return
	 */
	@PostMapping("/posts")
	public ApiResponse createPosts(@Valid @RequestBody Post post, Errors errors) {

		if (errors.hasErrors()) {
			// errors.getFieldErrors().forEach((error) -> {
			// errorMessage += error.getDefaultMessage() + "\n";
			// });
			String messages = errors.getFieldErrors().stream().limit(1).map((error) -> error.getDefaultMessage())
					.collect(Collectors.joining(""));

			throw new ApiException(com.example.hellorest.exceptions.Errors.MISSING_PARAMETER, messages);
			// return new ApiResponse("Failed", messages);
		}

		this.postsService.save(post);
		return new ApiDataResponse("OK", post, "");
	}

	@GetMapping("/posts")
	public ApiDataResponse getAllPosts() {
		
		// NumberFormatException 발생
		// Integer.parseInt("ABC");
		
		List<Post> allPosts = this.postsService.getAll();
		return new ApiDataResponse("OK", allPosts, "");
	}

	@PutMapping("/posts/{postId}")
	public ApiDataResponse updateOnePost(@PathVariable long postId, @RequestBody Post post) {
		Post onePost = this.postsService.updateOne(postId, post);
		return new ApiDataResponse("OK", onePost, "");
	}

	@GetMapping("/posts/{postId}")
	public ApiDataResponse selectOnePost(@PathVariable long postId) {
		Post onePost = this.postsService.getOne(postId);
		return new ApiDataResponse("OK", onePost, "");
	}

	@DeleteMapping("/posts/{postId}")
	public ApiResponse deleteOnePost(@PathVariable long postId) {
		this.postsService.removeOne(postId);
		return new ApiResponse("OK", "");
	}

}
