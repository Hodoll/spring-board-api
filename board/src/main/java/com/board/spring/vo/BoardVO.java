package com.board.spring.vo;

public class BoardVO {
	private String content_id;
	private String content_name;
	
	public BoardVO(String content_id, String content_name) {
	        this.content_id = content_id;
	        this.content_name = content_name;
	}
	
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getContent_name() {
		return content_name;
	}
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}
	
}
