package com.example.hellorest.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class IndexController {

	//	@RequestMapping("/")
	//	public String index() {
	//		return "index.html";
	//	}

	@GetMapping("/")
	public String index() {
		return "Hello, Boot! " + System.getenv("HOSTNAME");
	}
}
