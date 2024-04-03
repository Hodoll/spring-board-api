package com.board.spring.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class MaskingUtil {
	// 이름 가운데 글자 마스킹
	public static String nameMasking(String name) throws Exception {
		// 한글만 (영어, 숫자 포함 이름은 제외)
		String regex = "(^[가-힣]+)$";
		
		Matcher matcher = Pattern.compile(regex).matcher(name);
		if(matcher.find()) {
			int length = name.length();
			
			String middleMask = "";
			if(length > 2) {
				middleMask = name.substring(1, length - 1);
			} else {	// 이름이 외자
				middleMask = name.substring(1, length);
			}
			
			String dot = "";
			for(int i = 0; i<middleMask.length(); i++) {
				dot += "*";
			}
			
			if(length > 2) {
				return name.substring(0, 1)
						+ middleMask.replace(middleMask, dot)
						+ name.substring(length-1, length);
			} else { // 이름이 외자 마스킹 리턴
				return name.substring(0, 1)
						+ middleMask.replace(middleMask, dot);
			}
		}
		return name;
	}
}
