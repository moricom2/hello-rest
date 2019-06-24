package com.example.hellorest.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
//	@GetMapping("/")
//	public String index() {
//		return "Hello, Boot!";
//	}
}
