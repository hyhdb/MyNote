<h2>Spring Boot 기본기 & POST 요청 실습</h2>

<h3>🚀 Day 1 — Spring Boot 기본기 & POST 요청 실습</h3>

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

<h3>🚀 Day 2 — DB 연결 & H2 콘솔 설정</h3>

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

<h3>🚀 Day 3 — Entity · Repository 생성 & 게시글 등록·조회 기능 구현</h3>

📦 Day 3 학습 목표

- JPA Entity 생성 진행

- Repository 인터페이스 구현

- 게시글(Post) 데이터 저장·조회 기능 개발

- POST / GET API 구축

- Postman으로 게시글 CRUD 중 “등록 + 조회” 기능 검증 진행

🧩 개발 내용

- Post 엔티티를 만들어 JPA가 자동으로 테이블 생성하도록 설정 진행

- 게시글 정보를 전달받는 PostDto 작성 진행

- DB 저장 로직을 처리하는 PostService 구성 진행

- 게시글 API 요청을 처리하는 PostController 구현 진행

- H2 콘솔에서 실제 데이터 저장 여부 확인 진행

📮 Postman 테스트

✔ 게시글 등록 (POST)

- URL: POST http://localhost:8080/posts

- Body (raw / JSON):
{
"title": "첫 번째 글",
"content": "본문 내용"
}


- 결과: 저장된 게시글 정보가 JSON 형태로 응답 반환 진행

✔ 게시글 전체 조회 (GET)

- URL: GET http://localhost:8080/posts

- 결과: 저장된 게시글 목록이 배열 형태로 응답 반환 진행

🗄️ H2 콘솔 확인

- 접속 URL: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb

- 테이블 목록에서 POSTS 테이블 생성 여부 확인 진행

- SELECT * FROM POSTS 실행해 데이터 저장 상태 확인 진행

📁 현재까지 패키지 구조

```bash
📦 src
 └─📁 main
     └─📁 java
         └─📁 com.example.CRUD
             ├─📁 config
             │   └─📄 SecurityConfig.java
             │
             ├─📁 controller
             │   ├─📄 HelloController.java
             │   ├─📄 PostController.java
             │   └─📄 UserController.java
             │
             ├─📁 dto
             │   ├─📄 PostDto.java
             │   ├─📄 PostRequest.java
             │   ├─📄 PostResponse.java
             │   ├─📄 UserRequest.java
             │   └─📄 UserResponse.java
             │
             ├─📁 entity
             │   ├─📄 Post.java
             │   └─📄 User.java
             │
             ├─📁 repository
             │   ├─📄 PostRepository.java
             │   └─📄 UserRepository.java
             │
             └─📁 service
                 ├─📄 HelloService.java
                 ├─📄 PostService.java
                 └─📄 UserService.java

```



📘 Day 3 요약

- JPA 기반 Entity·Repository 구성 완료

- 게시글 등록 및 조회 API 개발 완료

- Postman 요청 검증 완료

- H2 콘솔에서 DB 동작 확인 완료

- Day 4에서 “수정 · 삭제 API”를 추가해 CRUD 완성 예정


<h3>🚀 Day 4 — 게시글 CRUD 완성</h3>

📦 Day 4 학습 목표
- 게시글 CRUD 전체 흐름 이해
- URL PathVariable 기반 요청 처리
- Service 계층에서 비즈니스 로직 분리
- Postman으로 CRUD 전 과정 검증

```bash
Day 4에 수정한 패키지
📦 src
 └─📁 main
     └─📁 java
         └─📁 com.example.CRUD
             ├─📁 controller
             │   └─📄 PostController.java
             │
             ├─📁 entity
             │   └─📄 Post.java
             │
             └─📁 service
                 └─📄 PostService.java

```

🧱 구현 기능 목록
- 게시글 등록 API 구현
- 게시글 전체 조회 API 구현
- 게시글 단건 조회 API 구현
- 게시글 수정 API 구현
- 게시글 삭제 API 구현

🔄 요청 처리 흐름
- Controller에서 HTTP 요청 수신
- DTO를 통해 요청 데이터 전달
- Service에서 비즈니스 로직 처리
- Repository를 통해 DB 접근
- Response DTO로 응답 데이터 반환

📮 Postman 테스트 항목
- 게시글 등록 요청 실행
- 게시글 전체 조회 요청 실행
- 게시글 단건 조회 요청 실행
- 게시글 수정 요청 실행
- 게시글 삭제 요청 실행
- 모든 요청은 Postman을 통해 직접 검증 완료

🚦 예외 처리 경험
- 존재하지 않는 게시글 조회 시 오류 발생 확인
- PathVariable 이름 미지정으로 인한 500 에러 발생 경험
- @PathVariable("id") 명시로 문제 해결 완료

📘 Day 4 요약

- 게시글 CRUD 전체 기능 구현 완료
- Controller / Service / Repository 역할 분리 이해
- REST API 기본 설계 방식 습득
- Postman 기반 API 검증 능력 확보
- 실무형 백엔드 구조 경험 완료


<h3>🚀 Day 5 — 공통 예외 처리 & 응답 포맷 통일</h3>

📦 Day 5 학습 목표
- 서버 오류 발생 시 일관된 JSON 응답 반환
- 예외 상황을 HTTP 상태 코드에 맞게 분리 처리
- API 응답 포맷을 하나의 구조로 통일
- 클라이언트 입장에서 예측 가능한 응답 설계

🧱 핵심 구현 내용
- 공통 응답 포맷 객체 설계
- 성공 / 실패 응답 구조 분리
- 커스텀 예외 클래스 도입
- 전역 예외 처리기 적용
- Controller 응답 구조 통일

```bash
📂 Day 5 추가 패키지 구조

📦 src
 └─📁 main
     └─📁 java
         └─📁 com.example.CRUD
            ├─📁 exception
            │  ├─📄 GlobalExceptionHandler.java
            │  └─📄 NotFoundException.java
            │
            └─📁 dto
               ├─📄 ApiResponse.java
               └─📄 ApiError.java

```


🔄 응답 처리 방식
- 정상 요청 시 success=true 응답 반환
- 데이터는 data 필드로 전달
- 오류 발생 시 success=false 응답 반환
- 오류 정보는 error 객체로 전달
- HTTP 상태 코드와 오류 의미 일치 처리

🚦 예외 처리 개선 사항
- 존재하지 않는 게시글 조회 시 404 오류 반환 처리
- 잘못된 요청 데이터 입력 시 400 오류 반환 처리
- 서버 내부 오류 발생 시 500 오류 반환 처리
- Whitelabel Error Page 미노출 처리

📮 Postman 테스트 결과
- 존재하지 않는 게시글 조회 요청 실행
- 404 상태 코드 정상 반환 확인
- 오류 메시지 JSON 형태로 응답 확인
- 모든 CRUD 요청에서 응답 포맷 일관성 확인

🧠 학습 포인트
- 예외는 Service 계층에서 발생 처리
- Controller는 정상 흐름만 담당
- 전역 예외 처리로 중복 코드 제거
- API 설계 시 클라이언트 관점 고려 필요성 이해

📘 Day 5 요약
- 공통 예외 처리 구조 구현 완료
- REST API 응답 포맷 통일 완료
- HTTP 상태 코드 의미에 대한 이해 강화
- 실무형 API 설계 방식 경험 완료


<h3>🚀 Day 6 — 회원(User) CRUD 연결</h3>

📦 Day 6 학습 목표
- User 도메인 추가
- 게시글(Post)과 동일한 구조로 회원 CRUD 구현
- Controller / Service / Repository / DTO / Entity 구조 재사용
- 공통 예외 처리 및 응답 포맷 유지
- Postman을 통한 전체 API 검증

```bash
📂 Day 5 수정 패키지 구조

📦 src
 └─📁 main
     └─📁 java
         └─📁 com.example.CRUD
            ├─📁 controller
            │  └─📄 UserController.java
            │
            ├─📁 service
            │  └─📄 UserService.java        
            │
            ├─📁 entity
            │  └─📄 User.java
            │
            └─📁 dto
               ├─📄 UserRequest.java
               └─📄 UserResponse.java

```

🧩 구현 기능 목록
- 회원 등록 API 구현
- 회원 전체 조회 API 구현
- 회원 단건 조회 API 구현
- 회원 정보 수정 API 구현
- 회원 삭제 API 구현

🔧 구현 특징
- 게시글(Post) CRUD와 동일한 설계 패턴 적용
- 요청(Request)과 응답(Response) DTO 분리 유지
- Service 계층에서 비즈니스 로직 처리
- Repository는 JpaRepository 기반으로 구성
- 존재하지 않는 회원 접근 시 예외 처리 적용
- 공통 응답 포맷(ApiResponse) 유지

📮 Postman 테스트 항목

✔ 회원 등록
- POST /users

✔ 회원 전체 조회
- GET /users

✔ 회원 단건 조회
- GET /users/{id}

✔ 회원 수정
- PUT /users/{id}

✔ 회원 삭제
- DELETE /users/{id}

📘 Day 6 요약
- User 도메인 CRUD 기능 구현 완료
- Post / User 도메인 구조 통일 완료
- REST API 설계 흐름 체득
- 공통 예외 처리 및 응답 구조 재사용
- Day 7 인증/로그인 기능 확장을 위한 기반 완성

<h3>🚀 Day 7 — JWT 기반 인증 및 로그인 구현</h3>

📦 Day 7 학습 목표
- JWT(JSON Web Token)의 개념과 동작 원리 이해
- Spring Security와 JWT를 연동한 무상태(Stateless) 인증 시스템 구축
- 비밀번호 암호화(BCrypt) 적용을 통한 보안 강화
- 로그인 성공 시 토큰 발급 및 필터를 통한 API 접근 제어 검증

```bash
📂 Day 7 추가 및 수정 패키지 구조

📦 src
 └─📁 main
     └─📁 java
         └─📁 com.example.CRUD
            ├─📁 config
            │  ├─📄 SecurityConfig.java         # 보안 필터 체인 및 JWT 필터 등록
            │  └─📄 PasswordEncoderConfig.java  # BCrypt 암호화 빈 설정 (NEW)
            │
            ├─📁 security                       # (NEW)
            │  ├─📄 JwtTokenProvider.java       # JWT 생성 및 검증 로직
            │  └─📄 JWTAuthenticationFilter.java # 모든 요청의 토큰을 검사하는 필터
            │
            ├─📁 controller
            │  └─📄 AuthController.java         # 로그인/회원가입 API (NEW)
            │
            ├─📁 service
            │  └─📄 AuthService.java            # 회원가입/로그인 비즈니스 로직 (NEW)
            │
            └─📁 dto
               ├─📄 LoginRequest.java           # 로그인 요청 DTO (NEW)
               ├─📄 LoginResponse.java          # 토큰 응답 DTO (NEW)
               └─📄 RegisterRequest.java         # 회원가입 요청 DTO (NEW)
```

🧱 핵심 구현 내용
- 비밀번호 안전 저장: BCryptPasswordEncoder를 사용하여 DB에 비밀번호를 해싱하여 저장.
- 토큰 기반 인증: 로그인 성공 시 사용자의 userid 정보를 담은 JWT를 생성하여 클라이언트에 전달.
- 인증 필터 구현: OncePerRequestFilter를 상속받아 모든 요청의 헤더에서 토큰을 추출하고 유효성을 검사.
- 보안 설정 확장: 인증 없이 접근 가능한 경로(로그인, 회원가입, H2 콘솔)와 인증이 필요한 경로를 분리 설정.

📮 Postman 테스트 결과
- 회원가입: POST /auth/register 요청 시 비밀번호가 암호화되어 DB에 저장됨을 확인.
- 로그인: POST /auth/login 성공 시 유효한 JWT 토큰이 반환됨을 확인.
- 인가 테스트: 유효한 토큰을 Authorization: Bearer <Token> 헤더에 담을 시 200 OK와 함께 데이터가 반환.
- 토큰이 없거나 잘못된 경우 403 Forbidden이 발생하여 리소스가 보호됨을 확인.

📘 Day 7 요약
- Spring Security와 JWT를 결합한 실무적인 인증 구조를 완성.
- 서버 세션을 사용하지 않는 무상태 인증 방식의 장점을 체득.
- 사용자 비밀번호 암호화와 토큰 만료 설정을 통해 보안 수준을 높임.