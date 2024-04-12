package com.board.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.spring.mapper.BoardMapper;
import com.board.spring.util.MaskingUtil;
import com.board.spring.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class BoardService {
	
	@Autowired
    private BoardMapper boardMapper;
	@Autowired
	private MailService mailService;	
	
	@Transactional(readOnly = true)
	public List<BoardVO> list() {
		log.debug("++++++++++++++++++++++++++++");
		List<BoardVO> List = boardMapper.list();
		for (BoardVO row : List) {
			String maskingContents = row.getContentName();
			row.setContentName(MaskingUtil.nameMasking(maskingContents));
		}
		return List;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> one(BoardVO boardVO) {
		return boardMapper.one(boardVO);
	}

	public int add(BoardVO boardVO) {
		return boardMapper.add(boardVO);
	}

	public int update(BoardVO boardVO) {
		return boardMapper.update(boardVO);
	}

	public int delete(BoardVO boardVO) {
		boardMapper.one(boardVO);
		mailService.run(boardVO);
		return boardMapper.delete(boardVO);
	}
}
