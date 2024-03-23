package com.board.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.spring.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<?> select();
	
	List<?> selectDetail(BoardVO boardVO);
	
	int add(BoardVO boardVO);
	
	int modify(BoardVO boardVO);
	
	int delete(BoardVO boardVO);
}
