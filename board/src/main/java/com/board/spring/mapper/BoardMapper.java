package com.board.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.board.spring.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> list();

	List<Map<String, Object>> one(BoardVO boardVO);

	int add(BoardVO boardVO);

	int update(BoardVO boardVO);

	int delete(BoardVO boardVO);
}
