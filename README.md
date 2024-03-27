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
 
