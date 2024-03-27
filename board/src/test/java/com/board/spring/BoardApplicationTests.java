package com.board.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.spring.service.BoardService;
import com.board.spring.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class BoardApplicationTests {
	@Autowired
	private BoardService boardService;
	
	@Test
	void list() {
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
}
