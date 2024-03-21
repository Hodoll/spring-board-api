package com.board.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class boardController {
	
	@GetMapping("/board/first")
	public String Test() {
		return "test123";
	}
	
}
