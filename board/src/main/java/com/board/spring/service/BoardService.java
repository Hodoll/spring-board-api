package com.board.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.spring.mapper.BoardMapper;
import com.board.spring.util.MaskingUtil;
import com.board.spring.vo.BoardVO;
import com.board.spring.vo.MailVO;

import jakarta.mail.MessagingException;

@Transactional
@Service
public class BoardService {
	
	@Autowired
    private BoardMapper boardMapper;
	@Autowired
	private MailService mailService;	
	
	@Transactional(readOnly = true)
    public List<Map<String, Object>> list(BoardVO boardVO) throws MessagingException {
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
    
    public int delete(BoardVO boardVO) throws MessagingException {
    	List<Map<String, Object>> list = boardMapper.one(boardVO);
    	MailVO.contentName = (String) list.get(0).get("CONTENT_NAME");
    	MailVO.contentDelDt = MaskingUtil.getCurrentDateTime();
    	
    	mailService.run(null);
		return boardMapper.delete(boardVO); 	
	}
}
