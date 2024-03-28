package com.board.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import com.board.spring.service.BoardService;
import com.board.spring.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ExtendWith(MockitoExtension.class)
class BoardApplicationTests {
	@Autowired
	private BoardService boardService;
	@Autowired TestRestTemplate restTemplate;
	@Test
	void list() {
		BoardVO boardVO = new BoardVO();
		boardService.list(boardVO);
	}

	@Test
	void one() {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId("1");
		boardService.list(boardVO);
	}

	@Test
	void add() {
		//null 삽입으로 에러 확인
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(null);
		boardService.add(boardVO);
	}
	@Test
	void update() {
		//null 삽입으로 에러 확인
		BoardVO boardVO = new BoardVO();
		boardVO.setOrderBy(null);
		boardService.update(boardVO);
	}
	@Test
	void delete() {
		BoardVO boardVO = new BoardVO();
		boardVO.setContentId("1");
		boardService.delete(boardVO);
	}
	
	@Test
    public void 학교_저장() throws Exception {

        //given
        //SchoolSaveDto saveDto = new SchoolSaveDto("서울c 학교", "<a ref='www.naver.com'> </a>", "1233");
        BoardVO boardVO = new BoardVO();
        boardVO.setContentId("1");
        boardVO.setContentName("<a ref='www.naver.com'> </a>");
        
        HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.APPLICATION_JSON);
       // headers.set("Authorization", accessToken);

       // HttpEntity<SchoolSaveDto> entity = new HttpEntity<>(saveDto, headers);

        //when
//        ResponseEntity<Long> response = restTemplate
//                .exchange(
//                "/api/v1/schools/insert",
//                HttpMethod.POST,
//                entity,
//                Long.class);

        boardService.list(boardVO);

        //then
      //  Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        Assertions.assertThat(school.getSchoolAddress()).isNotEqualTo("<a ref='www.naver.com'> </a>");
//        Assertions.assertThat(school.getSchoolAddress()).isEqualTo("&lt;a ref='www.naver.com'&gt; &lt;/a&gt;");

    }
}
