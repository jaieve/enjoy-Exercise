# Enjoy-Exercise 게시판 프로젝트
Spring, MySQL(Mybatis) 활용한 회원가입 및 게시판


## 1. 제작 동기 및 목표
백엔드 및 스프링MVC 학습을 마치고, 웹 애플리케이션 개발에 사용되는 기술을 활용하여 실무에서 어떻게 사용할 수 있을지 고민해보면서 회원가입 및 게시판 기능을 구현하는 것을 목표로 하고 프로젝트를 진행하였음.
### 개발순서
1. 스프링 프로젝트 생성
2. 스프링부트 웹서버 실행
3. 회원 도메인 개발
4. 웹 MVC 개발
5. DB연동(JSP, MyBatis, Oracle)


## 2. 개발환경
- DevelopOS : windows 10 Pro 64bit(RAM 8GB)
- Web/WAS server : Tomcat v8.5.64
- DBMS : Oracle 11g Express
- Framework : Springboot 4.3.30 (Maven)
- ORM : Mybatis 3.5.6


## 3. DB 스키마
![image](https://user-images.githubusercontent.com/77133233/160555671-09ab89f2-d79b-4fc5-8071-62877e7e2e29.png)
- USERS : 회원 기본정보 데이터를 저장한 테이블
- PERSONALINFO : 회원의 추가적인 개인정보 데이터를 저장한 테이블
- BOARD : 게시글 데이터를 저장한 테이블


## 4. 메뉴 및 기능 구조도
![image](https://user-images.githubusercontent.com/77133233/160552976-9947ffdb-487f-4539-ac38-6fb0749d5fa9.png)


## 5. 페이지별 기능
### a. 회원가입 및 로그인
![image](https://user-images.githubusercontent.com/77133233/160556204-a625daea-ddbc-4e2c-9c05-fe48b48a51a8.png)
- 접속 시 처음 보게 되는 페이지에서 상단 메뉴의 ‘Sign Up’ 이란 메뉴를 누르면 회원가입페이지로 이동
- ‘Sign In’ 클릭시 이동한 로그인 화면에서도 회원가입페이지로 이동가능
- 회원가입시 모든 항목을 채워야 form이 submit 되도록 JavaScript 로 회원가입 form 유효성 검사
- 회원가입에 성공하거나 상단 메뉴의'Sign In' 를 클릭하면 로그인 페이지로접근이 가능하다
![image](https://user-images.githubusercontent.com/77133233/160556309-29317120-f62f-4162-9271-32a9743ecb30.png)
- 회원가입에 성공하거나 상단 메뉴의'Sign In' 를 클릭하면 로그인 페이지로 접근이 가능하다
- 로그인에 성공하면 nav bar 의 메뉴가 바뀌어 보인다

### b. 개인정보 확인 및 변경
![프로필사진 변경](https://user-images.githubusercontent.com/77133233/160556454-89926ad5-7926-4df7-87d3-f919d604f531.png)
![image](https://user-images.githubusercontent.com/77133233/160556596-89f98f9d-a163-4de4-a170-5c6584db43bc.png)
- 닉네임, 개인정보, 프로필 사진 수정 / 회원탈퇴

### c. 게시판 조회/등록/수정/삭제
![posts](https://user-images.githubusercontent.com/77133233/160556700-0cb09ba3-917d-45fb-82d8-d26f8490f18a.png)
![post](https://user-images.githubusercontent.com/77133233/160556706-7f671b8d-2047-4864-82ec-56236e38b6e5.png)
- summernote 에디터 사용

![create](https://user-images.githubusercontent.com/77133233/160556730-2f0accd4-3e08-42c4-8e0a-7991079b5d7d.png)
- summernote 에디터 사용

![update](https://user-images.githubusercontent.com/77133233/160556753-dde4f25c-2ea1-428a-a3df-5ebc80a1d15a.png)
- summernote 에디터 사용

![delete](https://user-images.githubusercontent.com/77133233/160556811-7937e53a-6f84-4d4b-8d5d-f02a1df5f027.png)



## 6. 반응형 웹 디자인 패턴
![responsive1](https://user-images.githubusercontent.com/77133233/160553460-927fe8ff-bed9-46b4-bca8-8988f08d0f5a.png)
![responsive2](https://user-images.githubusercontent.com/77133233/160556968-1b18f73d-d9f0-4818-bce4-421e3d5a5511.png)


## 7. 프로젝트 후 소감
- 게시판 검색 및 댓글 기능을 백엔드 및 프론트 소스코드를 모두 완성해놓고서 프로젝트 버전관리에 미숙하였고, 프로젝트 마감일 까지 날려버린 소스코드를 다시 완성하는 것이 불가능 하여 프로젝트 초반 기획단계에 목표로한 게시글 검색, 댓글 기능, 출석체크 페이지 를 완성하지 못한 것이 아쉬움.
- 초기 기획시 데이터 구조가 복잡하지 않아서 DB Tables의 외래키 설정을 놓쳐서 데이터 관리가 되지 않는 RDBMS가 되었음. 실무에서 MyBatis가 아닌 JPA를 사용하는 경우가 늘어나는 이유에 대해 이해할 수 있었고, 추후 개인 프로젝트  진행시 ORM으로 JPA를 사용해볼 예정.
- 첫 프로젝트였고, 혼자서 진행한 탓에 기획 단계에서 충분한 고민과 요구사항분석을 제대로 하지 못한 아쉬움이 남음. 또한 기능 개발시 history 관리를 위해 git branch에 대해 더 공부하여 더 효율적인 개발의 필요성을 깨달음.
