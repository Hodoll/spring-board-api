package com.board.spring.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.spring.service.BoardService;
import com.board.spring.vo.BoardVO;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/board")
public class BoardController {
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	//# AutoWired를 지웠을때 @GetMapping("/board/select") url 입력시 에러가 났음. @Service 어노테이션이 선언 된 상태에서
	//autowired로 의존성을 주입받지 않아서 찾을 수가 없어서 에러가 난 건지 질문필요, @SpringBootApplication에서 component Scan이 일어나고 있는데, 여기에 선언이 되었기 떄문에
	// 바로 의존성을 주입할 수 있는거 같은데 확인필요.
	// 인터넷에서는 BoardMapper.JAVA의 패키지 경로와, Board.xml의 경로가 일치햐아 된다고 했는데 정확히 일치시켰을 떄에는 경로를 못찾아 에러가 났는데
	// 지금과 같은 형태로 나오니 해결됐음. 근데 왜 되는지 모르겠음. 
	// 질문필요함
	@Autowired
	private BoardService boardService;
	
	//전체리스트 조회
    @GetMapping("/list")
    public List<?> getContents(@RequestParam(value="ORDER_BY",  required = false, defaultValue="Y")  String ORDER_BY){
    	BoardVO boardVO = new BoardVO();
    	boardVO.setORDER_BY(ORDER_BY);
    	System.out.println("boardVO = " + boardVO.getORDER_BY());
    	return boardService.selectBoard(boardVO);
    }
	//개별리스트디테일 조회
    @GetMapping("/one")
    public List<?> getDetailContents(@RequestBody Map<String, String> param){
    	BoardVO boardVO = new BoardVO();
    	boardVO.setCONTENT_ID(param.get("CONTENT_ID"));
    	return boardService.selectDetail(boardVO);
    }
	//저장    
    @PostMapping("/add")
    public void addContents(@RequestBody Map<String, String> param) {
    	//System.out.println는 좋지 않으나, logger.Debug에서 에러메시지 출력이 안됨.. 이유는 모르겠다.. 추후 질문 필요
    	System.out.println("******************************"  + param);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setCONTENT_NAME(param.get("CONTENT_NAME"));
    	boardService.add(boardVO);
    }
	//수정    
    @PutMapping("/update/{CONTENT_ID}")
    public void updateContents(@PathVariable("CONTENT_ID") String CONTENT_ID, @RequestBody Map<String, String> param) {
    	System.out.println("*********" + CONTENT_ID);
    	System.out.println("*********" + param);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setCONTENT_ID(CONTENT_ID);
    	boardVO.setCONTENT_NAME(param.get("CONTENT_NAME"));
    	System.out.println("*********" + boardVO);
    	boardService.modify(boardVO);
    }
    //삭제
    @DeleteMapping("/delete/{CONTENT_ID}")
    public void deleteContents(@PathVariable("CONTENT_ID") String CONTENT_ID) {
    	System.out.println("*********" + CONTENT_ID);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setCONTENT_ID(CONTENT_ID);
    	System.out.println("*********" + boardVO);
    	boardService.delete(boardVO);
    }
}
