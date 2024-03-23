package com.board.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.spring.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<?> select();
	
	int add(BoardVO boardVO);
}
