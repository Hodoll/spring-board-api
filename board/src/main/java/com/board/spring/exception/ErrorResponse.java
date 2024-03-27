package com.board.spring.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private int errorCode;
	private String errorMessage;
	private Object data;
	
    public ErrorResponse(ErrorCode errorCode){
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
        this.data = errorCode.getData();
    }
}
