package com.board.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.spring.mapper.BoardMapper;
import com.board.spring.vo.BoardVO;

@Transactional
@Service
public class BoardService {
	
    private BoardMapper boardMapper;

	/*
	 * public BoardService(BoardMapper BoardMapper) { this.boardMapper =
	 * BoardMapper; }
	 */
    
    public List<?> list(BoardVO boardVO) {
    	return boardMapper.list(boardVO);
    }
    
    public List<?> one(BoardVO boardVO) {
    	return boardMapper.one(boardVO);
    }
    
    public int add(BoardVO boardVO) {
		return boardMapper.add(boardVO); 	
	}
    
    public int update(BoardVO boardVO) {
		return boardMapper.update(boardVO); 	
	}
    
    public int delete(BoardVO boardVO) {
		return boardMapper.delete(boardVO); 	
	}
}
