package com.board.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.board.spring.service.BoardService;
import com.board.spring.util.MaskingUtil;
import com.board.spring.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ExtendWith(MockitoExtension.class)
class BoardApplicationTests {
	@Autowired
	private BoardService boardService;
	@Autowired TestRestTemplate restTemplate;
	
	@Test
	void list() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardService.list(boardVO);
	}

	@Test
	void one() {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId("1");
		boardService.list(boardVO);
	}

	@Test
	void add() {
		//null 삽입으로 에러 확인
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(null);
		boardService.add(boardVO);
	}
	@Test
	void update() {
		//null 삽입으로 에러 확인
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(null);
		boardService.update(boardVO);
	}
	@Test
	void delete() {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId("1");
		boardService.delete(boardVO);
	}
	
	@Test
	void listMaskingTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		MaskingUtil.nameMasking(boardService.list(boardVO));
	}	
	
}
