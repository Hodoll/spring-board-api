package com.board.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404,"COMMON-ERR-404","페이지가 작동하지 않네요."),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","해당 ID는 존재하지 않습니다."),;

    private int errorCode;
    private String errorMessage;
    private Object data;
}
