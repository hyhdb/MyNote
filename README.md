Spring Boot 기본기 & POST 요청 실습

🚀 Day 1 — Spring Boot 기본기 & POST 요청 실습

Day 1에서는 Spring Boot 백엔드 개발의 기본 구조를 익히고
Controller / Service 분리, JSON 입력, POST 요청 처리까지 실습

📂 프로젝트 구조

- Controller: 클라이언트 요청을 받는 레이어

- Service: 실제 비즈니스 로직이 들어가는 레이어

- DTO: 요청/응답 데이터를 담는 객체

- Repository: (Day 2에서는 미사용) DB 연결용 구조

🎯 Day 1 학습 목표

- Spring Boot 기본 디렉토리 구조 이해

- Controller → Service 흐름 익히기

- DTO를 통해 JSON Request 받기

- Postman을 이용한 POST API 테스트

🛠 실행 방법

1. 프로젝트 실행 : ./gradlew bootRun 또는 IntelliJ에서 CrudApplication 실행

서버 구동: http://localhost:8080

📮 Postman 테스트
✔ POST 요청 보내기

- URL:  POST http://localhost:8080/users/create


- Header: Content-Type: application/json


- Body (raw / JSON): 
{
"name": "홍길동",
"age": 25
}


- 결과: 서버가 요청받은 데이터를 기반으로 성공 메시지를 반환

📘 요약

- Spring Boot의 3계층 구조 (Controller / Service / DTO)

- JSON 기반 POST 요청 처리

- Postman을 활용한 API 테스트 방법

- 패키지 구조 설계 방법

🚀 Day 2 — DB 연결 & H2 콘솔 설정

📦 Day 2 학습 목표

- H2 DB 설정 진행

- Spring Boot와 H2 인메모리 데이터베이스 연결

- H2 콘솔 접속 확인

- JPA 사용 준비

🔧 프로젝트 설정

- 설정 파일에 H2 콘솔 경로 등록 진행

- 인메모리 DB 동작 확인

- JPA 자동 테이블 생성 설정 진행

🌐 H2 콘솔 접속

- 접속 URL: http://localhost:8080/h2-console

- JDBC URL 입력: jdbc:h2:mem:testdb

- 사용자명: sa

- 접속 후 DB 상태 확인

🚦 H2 콘솔 접속 성공 기준

- 로그인 창에서 정상 연결됨 표시 확인

- JPA 엔티티 추가 시 자동 테이블 생성 확인 예정

📘 Day 2 요약

- H2 DB 활성화 설정 완료

- Spring Boot ↔ H2 연결 테스트 완료

- 콘솔 접속 경로 동작 확인

- Day3에서 사용할 Entity·Repository 준비 단계 완료