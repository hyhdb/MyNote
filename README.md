# 📓 MyNote - 개인형 메모 관리 시스템

### "단순한 게시판을 넘어, 나만의 비밀 노트를 만듭니다."

---

## 1. 프로젝트 소개
**MyNote**는 Spring Boot와 JPA를 기반으로 개발된 개인용 메모 관리 백엔드 서버입니다. 단순히 데이터를 저장하는 기능을 넘어, 사용자가 본인의 데이터에만 접근할 수 있도록 **Spring Security**와 **JWT(JSON Web Token)**를 활용한 보안 로직을 핵심적으로 구현하였습니다.

---

## 2. ⚡ 기존 CRUD 프로젝트와의 차별점

기존에 진행했던 `CRUD` 프로젝트가 **'누구나 볼 수 있는 게시판'**이었다면, **MyNote**는 **'나만 볼 수 있는 메모장'**입니다.

| 구분 | 기존 CRUD 프로젝트 | **MyNote 프로젝트** |
| :--- | :--- | :--- |
| **핵심 컨셉** | 공개형 게시판 | **개인형 비밀 메모장** |
| **인증 방식** | 무인증 또는 기본 세션 | **JWT 기반 무상태(Stateless) 인증** |
| **데이터 관계** | Post 단일 엔티티 | **User ↔ Memo (1:N 연관관계)** |
| **보안 로직** | 모든 데이터 공개 | **현재 로그인한 작성자의 데이터만 필터링** |
| **권한 검증** | - | **수정/삭제 시 작성자 일치 여부 확인** |

---

## 3. 핵심 기능 (Key Features)

### 🔐 보안 및 인증
* **비밀번호 암호화**: `BCryptPasswordEncoder`를 사용하여 사용자 비밀번호를 안전하게 해싱합니다.
* **JWT 인증**: 로그인 성공 시 발급되는 JWT 토큰을 통해 이후의 모든 API 요청을 인증합니다.
* **예외 처리**: 인증되지 않은 사용자가 접근 시 `401 Unauthorized`를 반환하도록 Security 설정을 강화했습니다.

### 📝 메모 관리 (CRUD)
* **메모 작성**: 현재 로그인한 사용자의 정보를 추출하여 해당 사용자와 연결된 메모를 생성합니다.
* **본인 메모 조회**: 전체 메모가 아닌, 현재 로그인한 사용자가 작성한 메모 목록만 조회할 수 있습니다.
* **수정 및 삭제 권한**: 메모의 ID와 현재 로그인한 사용자의 ID를 대조하여, 본인의 메모가 아닐 경우 수정을 차단합니다.

---

## 4. 기술 스택 (Tech Stack)

* **Language**: Java 17
* **Framework**: Spring Boot 3.x
* **Security**: Spring Security, JWT
* **Database**: H2 (In-memory)
* **ORM**: Spring Data JPA

---

## 5. API 명세 (핵심 주소)

| 기능 | 메서드 | URL | 인증 필요 |
| :--- | :--- | :--- | :---: |
| 회원가입 | `POST` | `/auth/register` | X |
| 로그인 | `POST` | `/auth/login` | X |
| 메모 작성 | `POST` | `/memos` | O |
| 내 메모 목록 | `GET` | `/memos` | O |
| 메모 수정 | `PUT` | `/memos/{id}` | O |
| 메모 삭제 | `DELETE` | `/memos/{id}` | O |

---

## 6. 실행 방법 (How to Run)

1. 이 저장소를 `Clone` 합니다.
2. `src/main/java/com/example/MyNote/MyNoteApplication.java` 파일을 실행합니다.
3. **Postman** 등의 도구를 사용하여 `/auth/register`로 계정을 생성합니다.
4. `/auth/login`으로 토큰을 발급받은 후, **Authorization** 헤더에 `Bearer {Token}` 형식을 추가하여 메모 기능을 테스트합니다.