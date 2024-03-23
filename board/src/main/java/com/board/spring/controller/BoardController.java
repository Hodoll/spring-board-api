package com.board.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.spring.service.BoardService;
import com.board.spring.vo.BoardVO;

@RestController
public class BoardController {
	
	//# AutoWired를 지웠을때 @GetMapping("/board/select") url 입력시 에러가 났음. @Service 어노테이션이 선언 된 상태에서
	//autowired로 의존성을 주입받지 않아서 찾을 수가 없어서 에러가 난 건지 질문필요, @SpringBootApplication에서 component Scan이 일어나고 있는데, 여기에 선언이 되었기 떄문에
	// 바로 의존성을 주입할 수 있는거 같은데 확인필요.
	// 인터넷에서는 BoardMapper.JAVA의 패키지 경로와, Board.xml의 경로가 일치햐아 된다고 했는데 정확히 일치시켰을 떄에는 경로를 못찾아 에러가 났는데
	// 지금과 같은 형태로 나오니 해결됐음. 근데 왜 되는지 모르겠음. 
	// 질문필요함
	@Autowired
	private BoardService boardService;
	
	
    @GetMapping("/board/select")
    public List<?> getContents(){
    	return boardService.selectBoard();
    }
	
    @PostMapping("/board/add")
    public void addContents(@RequestParam Map<String, String> signupForm) {
    	BoardVO boardVO = new BoardVO();
    	boardVO.setContent_id(signupForm.get("CONTENT_ID"));
    	boardVO.setContent_name(signupForm.get("CONTENT_NAME"));
    	boardService.add(boardVO);
    }
}
