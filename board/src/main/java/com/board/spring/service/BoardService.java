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

    public BoardService(BoardMapper BoardMapper) {
    	this.boardMapper = BoardMapper;
	}
    
    public List<?> selectBoard(BoardVO boardVO) {
    	return boardMapper.select(boardVO);
    }
    
    public List<?> selectDetail(BoardVO boardVO) {
    	return boardMapper.selectDetail(boardVO);
    }
    
    public int add(BoardVO boardVO) {
		return boardMapper.add(boardVO); 	
	}
    
    public int modify(BoardVO boardVO) {
		return boardMapper.modify(boardVO); 	
	}
    
    public int delete(BoardVO boardVO) {
		return boardMapper.delete(boardVO); 	
	}
}
