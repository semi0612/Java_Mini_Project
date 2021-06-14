# 프로젝트 소개
### 1.1 프로그램
도서 판매 사이트 작성

### 1.2 개발기간
2021.04.20 - 2021.05.28

### 1.3 팀원
프로그래밍 : 이정연, 최샘이
디자인 구성 : 김용욱

### 1.4 개발 환경
Eclipse (Java8_oxygen version)
Oracle DataBase
JSP
Visual Studio Code

------------------
<br><br>

# 프로젝트 개요
### 2.1 DB - ERD
![image](https://user-images.githubusercontent.com/51469989/121866142-9fa2ab00-cd39-11eb-9bca-3efd1786f590.png)


### 2.2 메인 화면 설계
![image](https://user-images.githubusercontent.com/51469989/121866290-bfd26a00-cd39-11eb-9556-8c7a31cbfbc9.png)
- 가장 상단의 `로그인/회원가입` 헤더는 로그인 시 `로그아웃/마이페이지`로 변경될 것
- 사이트 로고/네비게이션 바/footer 값은 고정

------------------
<br><br>

# 구현한 부분 중 일부 발췌
### 로그인
![image](https://user-images.githubusercontent.com/51469989/121866751-32434a00-cd3a-11eb-8f40-4022a1044800.png)

- 아이디 : 아이디 입력
- 비밀번호 : 비밀번호 입력
- 아이디 저장 : 입력된 아이디 값 저장
- Login: 로그인 버튼

### 메인화면
![image](https://user-images.githubusercontent.com/51469989/121866827-45eeb080-cd3a-11eb-89fa-92bfb066e4c1.png)

- 로그인 : 회원 로그인
- 회원가입 : 사이트에 회원으로 가입
- Home : 메인 화면으로 이동
- 카테고리 : 하위 메뉴로 이동
- 대여서비스 : 도서 대여신청 창으로 이동
- 추천 서비스 : 미구현
- 검색창 : 현재 사이트에 입고되어 있는 도서를 검색하기

### 회원 가입 창
![image](https://user-images.githubusercontent.com/51469989/121892369-9d4f4980-cd57-11eb-9fac-699e6a04415a.png)

- 아이디 : 영문자+특수문자+숫자의 조합으로 특정 개수 이상 입력
- 비밀번호 : 영문자+특수문자+숫자의 조합으로 특정 개수 이상 입력
- 주소 : 주소 검색으로 검색 후 상세 주소 입력
- 번호 : 서식에 맞추어 숫자와 하이픈(-) 만으로 입력
- 이메일 : 문의 답변을 받을 이메일을 형식에 맞추어 입력

### 도서 카테고리
![image](https://user-images.githubusercontent.com/51469989/121892487-cd96e800-cd57-11eb-87e0-b5080d280d3e.png)

- 드롭다운 형식으로 되어있다.
- 상위의 `카테고리` 부분을 누르면 드롭다운으로 하위 카테고리가 노출된다.


<br><br>

## (관리자)
- 관리자(미리 코드부분에서 admin으로 필터링)
- 
### 상품(도서) 입고
![image](https://user-images.githubusercontent.com/51469989/121892608-f4edb500-cd57-11eb-8900-2ee31e8fa437.png)

- 관리자로 로그인 하면 최상단의 헤더가 위와 같이 변경된다.
- 이 중 입고하기 버튼을 누르면 아래와 같은 페이지로 이동되고,
- 
![image](https://user-images.githubusercontent.com/51469989/121892616-f61ee200-cd57-11eb-9fdb-61dad0a19e79.png)

- 입고할 도서 정보를 양식에 맞게 기입한다.
- 기입 후 등록하기를 누르면 연동된 DB에 저장된다.
- `다시 작성하기`를 선택하면 입력한 내용이 초기화된다.

### 입고된 도서 관리(수정)

![image](https://user-images.githubusercontent.com/51469989/121893016-72b1c080-cd58-11eb-8086-823a9d4e7c87.png)

- 관리자 로그인 후 최상단에 노출된 목록 중 `상품 관리하기` 선택
- 
![image](https://user-images.githubusercontent.com/51469989/121893060-7f361900-cd58-11eb-8b2c-a5d9ecd6d98c.png)

- 현 시각 사이트에 존재하는 상품(도서)의 정보가 모두 출력된다.
- 정보를 수정하고 싶은 상품 하단에 있는 `수정하기` 버튼 클릭
- 
![image](https://user-images.githubusercontent.com/51469989/121893256-b6a4c580-cd58-11eb-879e-f36b4f7fefba.png)

- 편집 페이지에서 양식에 맞게 수정하고 싶은 내용을 수정 후 재등록한다.

### 상품(도서) 삭제

![image](https://user-images.githubusercontent.com/51469989/121893436-ebb11800-cd58-11eb-862a-9441d7f0c5c5.png)

- 관리자 로그인 후 최상단에 노출된 메뉴에서 `상품 삭제하기` 선택
- 
![image](https://user-images.githubusercontent.com/51469989/121893495-f9ff3400-cd58-11eb-9a03-c625b7034a17.png)

- 현 시각 사이트에 존재하는 상품(도서)의 정보가 모두 노출되며, 삭제하고픈 제품 하단에 위치한 `삭제` 버튼을 클릭
- 다른 페이지로의 이동 없이 바로 DB에서 해당 도서의 값이 사라진다.



<br><br>

## 고객 센터

![image](https://user-images.githubusercontent.com/51469989/121893711-421e5680-cd59-11eb-82c8-6a4591831dca.png)

### 사용자
- 상단 메뉴 중 고객센터를 선택
- 게시판 기능이 구현되어있어 글 작성 가능

### 관리자
- 상단 메뉴 중 고객센터를 선택
- 게시판 기능
- 글 작성 외에도 작성된 게시글을 선택해 답변할 수 있는 기능
- 답변 시 댓글로 달리는 것이 아니라 사용자(고객)이 회원가입 때 기입한 이메일로 답변이 발송된다.

### 마이페이지

![image](https://user-images.githubusercontent.com/51469989/121894015-99bcc200-cd59-11eb-856d-1e0cd2f3aed6.png)

- 로그인 시 최상단에 노출되는 목록 중 하나이다.
- 보안을 위해 접속시 한번 더 자신의 비밀번호를 입력해야한다.

### 회원 정보 수정

![image](https://user-images.githubusercontent.com/51469989/121894099-b1944600-cd59-11eb-97d2-1215e18819a4.png)


------------------
<br><br>

# 미구현된 부분
추천 서비스
마이페이지 일부 구간
