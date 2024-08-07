# 자바 빈, POJO, 스프링 빈

- POJO : 오래된 방식의 간단한 자바 오브젝트 (모든 자바객체는 POJO)
- 자바 빈 : 기본적으로 no-arg생성자를 가짐, getters, setters를 가짐, Serializable를 구현해서 클래스를 직렬화
- 스프링 빈 : 스프링 프레임워크에 의해 관리되는 오브젝트

# REST API의 개념

- REST: "REpresentational State Transfer"의 약자로, 웹에서 데이터를 교환하는 방식 중 하나

# HTTP 메서드
- GET: 자원을 조회, 예를 들어, GET /users는 사용자 목록을 조회
- POST: 새로운 자원을 생성, 예를 들어, POST /users는 새로운 사용자를 생성
- PUT: 전체 자원을 수정, 예를 들어, PUT /users/1는 ID가 1인 사용자의 정보를 수정
- PATCH: 전체 자원을 수정하는 PUT과 달리, 자원의 일부분만 수정
- DELETE: 자원을 삭제, 예를 들어, DELETE /users/1는 ID가 1인 사용자를 삭제
