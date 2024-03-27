package com.board.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.spring.service.BoardService;
import com.board.spring.vo.BoardVO;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 전체리스트 조회
	@GetMapping("/list")
	public List<?> list(@RequestParam(value = "ORDER_BY", required = false, defaultValue = "Y") String orderBy) {
		// System.out.println("boardVO = " + boardVO.getORDER_BY());
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(orderBy);

		return boardService.list(boardVO);
	}

	// 개별리스트디테일 조회
	@GetMapping("/one")
	public List<?> one(@RequestBody Map<String, String> param) {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId(param.get("CONTENT_ID"));

		return boardService.one(boardVO);
	}

	// 저장
	@PostMapping("/add")
	public void add(@RequestBody Map<String, String> param) {
		// System.out.println는 좋지 않으나, logger.Debug에서 에러메시지 출력이 안됨.. 이유는 모르겠다.. 추후 질문 필요
		// System.out.println("******************************" + param);
		BoardVO boardVO = new BoardVO();
		boardVO.setContentName(param.get("CONTENT_NAME"));

		boardService.add(boardVO);
	}

	// 수정
	@PutMapping("/update/{CONTENT_ID}")
	public void update(@PathVariable("CONTENT_ID") String contentId, @RequestBody Map<String, String> param) {
		// System.out.println("*********" + CONTENT_ID);
		// System.out.println("*********" + param);
		// System.out.println("*********" + boardVO);
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId(contentId);
		boardVO.setContentName(param.get("CONTENT_NAME"));

		boardService.update(boardVO);
	}

	// 삭제
	@DeleteMapping("/delete/{CONTENT_ID}")
	public void delete(@PathVariable("CONTENT_ID") String contentId) {
		// System.out.println("*********" + CONTENT_ID);
		// System.out.println("*********" + boardVO);
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId(contentId);

		boardService.delete(boardVO);
	}
}
