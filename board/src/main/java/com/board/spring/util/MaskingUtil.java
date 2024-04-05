package com.board.spring.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaskingUtil {
	// 이름 가운데 글자 마스킹
	public static List<Map<String,Object>> nameMasking(List<Map<String, Object>> list) throws Exception {
		String name, regex= "";
		List<Map<String, Object>> ListArr = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> hashmap = new HashMap<String, Object>(list.get(i));
			name = (String) hashmap.get("CONTENT_NAME");
			Matcher matcher = Pattern.compile(regex).matcher(name);
			if (matcher.find()) {
				int length = name.length();

				String middleMask = "";
				if (length > 2) {
					middleMask = name.substring(1, length - 1);
				} else { // 이름이 외자
					middleMask = name.substring(1, length);
				}
				
				//미들네임을 *처리 해주기 위한 로직
				String dot = "";
				for (int j = 0; j < middleMask.length(); j++) {
					dot += "*";
				}
				
				//3글자부터는 홍*동 
				if (length > 2) {
					name = name.substring(0, 1) + middleMask.replace(middleMask, dot)
							+ name.substring(length - 1, length);
				} else { // 이름이 외자일때 홍*
					name = name.substring(0, 1) + middleMask.replace(middleMask, dot);
				}
			}
			//맵형식으로 담아서 리스트ADD처리 하여 리턴
			hashmap.put("CONTENT_NAME", name);
			ListArr.add(hashmap);
		}
		log.debug("list == >>>> " + ListArr);
		return ListArr;
	}
}
