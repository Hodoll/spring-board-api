package com.board.spring.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaskingUtil {
	// 이름 가운데 글자 마스킹
	public static String nameMasking(String maskingContents) {
			//FIXME 정규식을 현재 사용하지 않기에  코드 리팩토링 수정 
			int length = maskingContents.length();

			String middleMask = "";
			if (length > 2) {
				middleMask = maskingContents.substring(1, length - 1);
			} else { // 이름이 외자
				middleMask = maskingContents.substring(1, length);
			}
			//미들네임을 *처리 해주기 위한 로직
			String dot = "";
			for (int j = 0; j < middleMask.length(); j++) {
				dot += "*";
			}
			//3글자부터는 홍*동 
			if (length > 2) {
				maskingContents = maskingContents.substring(0, 1) + middleMask.replace(middleMask, dot)
						+ maskingContents.substring(length - 1, length);
			} else { // 이름이 외자일때 홍*
				maskingContents = maskingContents.substring(0, 1) + middleMask.replace(middleMask, dot);
			}
		return maskingContents;
	}
}
