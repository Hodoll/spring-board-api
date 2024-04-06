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
import com.board.spring.service.MailService;
import com.board.spring.util.MaskingUtil;
import com.board.spring.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MailService mailService;
	
	// 전체리스트 조회
	@GetMapping("/list")
	public List<Map<String, Object>> list(@RequestParam(value = "ORDER_BY", required = false, defaultValue = "Y") String orderBy) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(orderBy);
		mailService.run(null);
		return MaskingUtil.nameMasking(boardService.list(boardVO));
	}

	// 개별리스트디테일 조회
    @GetMapping("/one")
    public List<Map<String, Object>> getDetailContents(@RequestBody Map<String, String> param){
    	BoardVO boardVO = new BoardVO();
    	boardVO.setContentId(param.get("CONTENT_ID"));
    	
    	return MaskingUtil.nameMasking(boardService.one(boardVO));
    	
    }

	// 저장
	@PostMapping("/add")
	public void add(@RequestBody Map<String, String> param) {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentName(param.get("CONTENT_NAME"));

		boardService.add(boardVO);
	}

	// 수정
	@PutMapping("/update/{CONTENT_ID}")
	public void update(@PathVariable("CONTENT_ID") String contentId, @RequestBody Map<String, String> param) {

		BoardVO boardVO = new BoardVO();
		boardVO.setContentId(contentId);
		boardVO.setContentName(param.get("CONTENT_NAME"));

		boardService.update(boardVO);
	}

	// 삭제
	@DeleteMapping("/delete/{CONTENT_ID}")
	public void delete(@PathVariable("CONTENT_ID") String contentId) {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId(contentId);

		boardService.delete(boardVO);
	}
}
