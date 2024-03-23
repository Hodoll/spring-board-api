package com.board.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.spring.mapper.BoardMapper;
import com.board.spring.vo.BoardVO;

@Service
public class BoardService {
	
    private BoardMapper boardMapper;

    public BoardService(BoardMapper BoardMapper) {
    	this.boardMapper = BoardMapper;
	}
    
    public List<?> selectBoard() {
    	System.out.println("********************");
    	return boardMapper.select();
    }
    
    public int add(BoardVO boardVO) {
		return boardMapper.add(boardVO);
    	
	}
}
