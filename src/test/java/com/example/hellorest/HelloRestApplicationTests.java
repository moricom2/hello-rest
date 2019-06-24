package com.example.hellorest;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.hellorest.posts.model.Post;
import com.example.hellorest.response.ApiDataResponse;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloRestApplicationTests {

	@Value("${local.server.port}") // 서버의 환경변수 가져올때
	private int port; // 테스트 서버의 포트

	private RestTemplate rest;
	private HttpHeaders header;

	@Before
	public void setUp() {
		rest = new RestTemplate();
		header = new HttpHeaders();
		header.add("Content-Type", "application/json");
	}

	@Test
	public void createPost() {

		Post post = new Post(1, "Test Subject", "Test Description");

		Gson gson = new Gson();
		String postJson = gson.toJson(post);

		// header = new HttpHeaders();
		// header.add("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(postJson, header);

		// rest = new RestTemplate();

		ResponseEntity<String> response = rest.exchange("http://localhost:" + port + "/posts", HttpMethod.POST, entity,
				String.class);

		// 응답의 Body 가져오기
		String responseBody = response.getBody();
		ApiDataResponse dataResponse = gson.fromJson(responseBody, ApiDataResponse.class);

		// 요청 -> 응답 끝

		// 검증
		// 1. status == OK
		assertTrue(dataResponse.getStatus().equals("OK"));

		// 2. 요청 subject, content 가 응답 subject, content 와 같은지 검증
		Map responsePost = (Map) dataResponse.getData();

		assertTrue(responsePost.get("subject").equals(post.getSubject()));

		assertTrue(responsePost.get("content").equals(post.getContent()));

	}

	@Test
	public void createPost_Failed() {

		Post post = new Post(1, "Test Subject", "Test Description");

		Gson gson = new Gson();
		String postJson = gson.toJson(post);

		// header = new HttpHeaders();
		// header.add("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(postJson, header);

		// rest = new RestTemplate();

		ResponseEntity<String> response = rest.exchange("http://localhost:" + port + "/posts", HttpMethod.POST, entity,
				String.class);

		// 응답의 Body 가져오기
		String responseBody = response.getBody();
		ApiDataResponse dataResponse = gson.fromJson(responseBody, ApiDataResponse.class);

		// 요청 -> 응답 끝

		// 검증
		// 1. status == OK
		assertTrue(dataResponse.getStatus().equals("OK"));

		// 2. 요청 subject, content 가 응답 subject, content 와 같은지 검증
		Map responsePost = (Map) dataResponse.getData();

		assertTrue(responsePost.get("subject").equals(post.getSubject()));

		assertTrue(responsePost.get("content").equals(post.getContent()));

	}

}
