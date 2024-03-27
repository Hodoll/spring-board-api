package com.board.spring.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private String contentId;
	private String contentName;
	private String contentRegDt;
	private String contentModDt;
	private String contentStatus;
	private String orderBy;
	
}
