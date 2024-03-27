package com.board.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.spring.mapper.BoardMapper;
import com.board.spring.vo.BoardVO;

@Transactional
@Service
public class BoardService {
	
	@Autowired
    private BoardMapper boardMapper;
	
	@Transactional(readOnly = true)
    public List<Map<String, Object>> list(BoardVO boardVO) {
    	return boardMapper.list(boardVO);
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
		return boardMapper.delete(boardVO); 	
	}
}
