프론트와 협업

회원 정보는 무엇을 받아와야 하는지(주소, 나이 ,이메일 등 )



1단계 인증

Token 기반의 로그인

회원가입

회원 정보 수정 

회원 탈퇴



----

2단계 장바구니/ 주문 API 변경하기 때 사용한다.

그래서 각각 4벌의 API가 나오는 것이다.



인증 (Authentication) - 사용자가 누구인지 확인하는 것

인가(Authorization) - 허용된 공간인지 확인하는것



---

권한 체크 기능을 추가 한다면?

권한 체크 로직 추가



Interceptor / MethodArgumentResolver를 사용해보는 것도 좋다



장바구니 코드는 뼈대 코드이기 때문에, 팀원들끼리 어떻게 해보는게 좋을까 컨벤션이나 스타일을 만들어 보는게 좋을듯하다.



