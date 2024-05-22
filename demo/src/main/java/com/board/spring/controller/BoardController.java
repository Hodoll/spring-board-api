package com.board.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class BoardController {
	
	// 전체리스트 조회
	@GetMapping("/")
	public String list() {
		return "1234";
	}

}
