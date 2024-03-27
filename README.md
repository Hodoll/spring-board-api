# spring-board-api
1주차 트러블 슈팅 및 새로 배운 것들 정리
 - Git 설정을 처음 할 떄 안된 이유
   =>2021년 이후로 아이디 & 패스워드 => 아이디 & 토큰으로 변경되었음. 비밀번호 대신 토큰을 발급해야 함.
   =>토큰발급 시 아래와 순서가 맞지 않으면 무한 로그인창이 뜸 
    
 - GIT 계정 및 연동 
   => repository생성 => settings => developer settings => 토큰발급(repo check) => clone a repository 정보입력
   => remote(origin) 우클릭 Change Credential에 아이디(email), 패스워드(token)입력 후 save => 그 후 share프로젝트로 연결하면 정상처리 됨 (문제해결 4시간소요)
 - Java 클래스를 정상적으로 생성했음에도 불구하고, Java Class notFound 에러발생 
   => Project Clean 시도 후 실패하여 Maven Update로 해결 
 - Controller / RestController의 차이점
   => Controller는 View를 반환하기 위하여 사용되며 Json같은 데이터 반환은 @ResponseBody사용
   => RestController는 Json 형태로 객체 데이터를 반환하는것 (Controller + ResponseBody의 결합)       
 
 - 클래스 명은 대문자, 메소드 명은 소문자
 
 - my sql  show databases => use 스키마명 해야함
 
 - 의존성 추가를 바로 하고 싶을 땐, 프로젝트 우클릭 => spring => Add Starters에서 추가하면 간편하게 할 수 있음
 
 - 커밋 메시지 규칙
 
 - 스프링부트에는 자동으로 최종단인 BoardApplication.java에 @SpringBootApplication이 선언되어 있음. 이 안을 들어다보면
   ComponentScan이 선언되어 있어서 따로 Component scan을 내가 직접 설정하지 않아도 @service, @controller등을 찾아 가는 것으로 보여짐. 확인필요
   
 - Lombok으로 인해 @getter, @setter를 따로 안만들어줘 된다 => 끝판왕인 @Data를 쓰면 저것조차 선언필요X. 근데 어노테이션은 뜨는데 왜 자동생성이 안되는지, 어느부분이 잘못됐는지 모르겠음.
 
 - Lombok 인식이 자꾸 안돼서 Help -> Install New Software에서 재설치하니까 된다. (참조:https://sunny-jang.tistory.com/35) 
 
 - https://okky.kr/questions/826709 << 질문필요 (VO는 왜 autowired가 안되는지.)
 
 - Mybatis 인자값을 받을 떄, VO의 대소문자를 가림 <= 확인필수 (1시간소요)
 
 - POSTMAN (post는 값을 직접 넣어볼 수 없기때문에 API에서는 postman에 값을 대입하여 테스트함)
 
 - POSTMAN 테스트할 때 Get,Put,Delete etc.. 잘 설정하고 submit해야함.. GetMapping 해놓고 Put 설정으로 Submit하니까 에러 계속남.. (Request method 'PUT' not supported)
 
 - @transactional (readonly = true)는 조회에 사용되며 성능상의 이점 뿐 아니라 해당 메서드가 조회용 메서드임을 알 수 있어 가독성 측면에서도 이점을 가진다.

 - 테스트 코드 작성은 /board/src/test/java/com/board/spring/ 경로에 작성하였으며, 기본적으로 생성되어있어서 junit 등을 따로 POM.XML에 추가할 필요 없었음
   
 - @SpringBootTest가 있는 메인으로 가서 필요 서비스 AUTOWIRED로 의존성 주입 = > @TEST메소드 추가 후 진행. 서버를 올렸다 내리는 것보다 훨씬 빠르게 결과물을 볼 수 있어서 시간상 굉장히 이점이 있다고 느껴짐
   현재 프로젝트에서도 사용해볼 예정
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

기본사항
   ⁃   네이밍룰				=> 표준을 준수하여 변경완료 
   ⁃   들여쓰기 패턴(예쁜 코드 만들기)		=> 기본적 들여쓰기 후 Ctrl + Shift + F 키로 자동들여쓰기 처리
   ⁃   패키지규칙				=>What I Learned 패키지를 소문자 패키지 규칙 위반으로 삭제하였으며 README 파일로 대체하였음

과제 미비된 부분
   ⁃   요구하는 API 스펙과 다르게 개발(endpoint, parameters, return value)  => 수정완료
   ⁃   테스트코드 미개발=> 테스트코드 작성중 . . . Ing 

코드리뷰
   ⁃   ServletInitializer.java 는 어떤 역할을 하나요?( 테스트 파일이면 어떤 테스트를 하려고 만든건가요? )  => 패키징을 Jar가 아닌 War로 배포할때 사용함. 처음 스프링 부트 실행 할 떄 JAR가 아닌 WAR로 만들었기에 자동 생성. Aws 등 클라우드에 반영 여부 미정으로 일단 유지
   ⁃   BoardVO의 컬럼명은 왜 스네이크 케이스로 작성되어 있나요?	 => 현 '동XX 고효율 정보시스템 구축' 프로젝트에서 사용하는 방식대로 명명 규칙을 정하였으나, 표준을 다시 맞춰 변경
   ⁃   BoardVO의 lombok 애노테이션은 각각 어떤 역할을 하나요? => @DATA를 쓴 이유는 @getter와 @setter를 선언하지 않아도, 전체를 포함하고 있어 편의상 사용하였으나 코드리뷰 후 사용하지 않는 불필요한 어노테이션까지 함께 사용되기에 다시 재변경 하였음
   ⁃   BoardController의 getDetailContents() 리턴타입이 제네릭으로 선언된 이유는?			=> 편의상 사용했으나, 수정하였음.
   ⁃   BoardService에서 boardMapper의 의존성을 주입할 때 생성자 방식을 사용한 이유는?		=> 필드주입방식으로 수정
   ⁃   로그 라이브러리로 logback을 사용한 이유는?( 동작하지 않아서 sout으로 대체한 것 같은데 그렇다면 라이브러리를 정확하게 사용하지 못하고 있는 것으로 보임) => logback을 고집한 이유는 없으며, sout을 log.debug로 나오게 logback.xml 레벨 INFO => DEBUG로 수정
   
커밋 메세지
   ⁃   UPDATE 커밋메세지는 어떤 상황에 사용하나요?=> 명명규칙 수정완료 
   ⁃   커밋태그에 대괄호를 사용 X=> 수정완료
개선사항
   ⁃   BoardController의 API들은 모두 “/board” 하위 경로를 갖으므로 컨트롤러 레벨의 RequestMapping을 선언하면 좋음=> 개선완료
   ⁃   System.out.println() 대신 log 라이브러리를 사용해야함(이유는 조사해보기)=> 개선완료
   ⁃   BoardController의 메서드 중 파라미터의 명명칙 위반사항을 일괄로 맞춰야함(ex. CONTENT_ID는 contentId로 변경)=> 개선완료
   ⁃   Service layer에서는 트랜잭션 선언이 필요(조회만 하는 경우 ReadOnly=true를 주면 속도 개선 가능)=> 개선완료

질문사항
Q. AutoWired를 지웠을때 @GetMapping("/board/select") url 입력시 에러가 났음. @Service 어노테이션이 선언 된 상태에서 autowired로 의존성을 주입받지 않아서 찾을 수가 없어서 에러가 난 건지 질문필요,
A. @Autowired가 하는 역할은 필드에 적합한 빈을 찾아 주입. 없으면 주입할 수 없어 null인 상태로 사용.
Q.@SpringBootApplication에서 component Scan이 일어나고 있는데, 여기에 선언이 되었기 떄문에 바로 의존성을 주입할 수 있는거 같은데 확인필요.
A. @ComponentScan은 의존성을 주입하는 역할 X. @Componont를 읽어 빈으로 등록할 대상을 찾는 역할(말 그대로 컴포넌트 스캔)
Q. 인터넷에서는 BoardMapper.JAVA의 패키지 경로와, Board.xml의 경로가 일치햐아 된다고 했는데 정확히 일치시켰을 떄에는 경로를 못찾아 에러가 났는데 지금과 같은 형태로 나오니 해결됐음. 근데 왜 되는지 모르겠음.
A.  자동으로 매핑시키는 것은 DAO를 생략할 때 가능해보이는데, 어떤 상황인지 조금 더 볼 필요가 있습니다(재현 필요)
