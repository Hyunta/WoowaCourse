## HTTP Caching

Http 성능을 향상 시키는 HTTP Cache

응답을 왜 재사용할까요?



Client가 Server에 요청을 보내고 Server가 응답을 보내준다.

클라이언트가 응답을 저장해놨다가 바로 쓰면 훨씬 빠르다.

서버는 부하가 줄어들어서 이득이다.



cache의 유형은 두가지다

private - 사용자의 개인화된 응답 / 내 로컬 브라우저에서만 갖고 있음

 shared 

- Proxy - 개발자가 직접 제어할 수는 없다 / httpHeader를 통해서 알려줄 수만 있다.
- Managed - 제어 가능하다 / ReverseProxy or CDN(Aws CloudFront or CloudFlare) cache 설정을 따로 할 수 있다.



### 캐시 유효기간

응답이 얼마나 유효하냐?

200 OK 이고

Date 와 Cache-Control을 준다

Date : Tue, 22 Feb ~~

Cache-Control: max-age=604800

- 604800초 -> 일주일
- max-age를 지나지 않으면 fresh / 지나면 stale / ~~expires~~ http 1.1 이전에 쓰던 헤더



### 재검증

- 유효성 검증 validation 또는 재검증 revalidation
- 조건부 요청 conditional request
  - if modified since : 날짜
  - ETag / If-None-Match : Tag값을 받아서 기준으로 재검증을 해야하는지 확인



**If-Modified-Since**

- 브라우저가 다시 요청을 보낼 때 LastModified value를 If-modified-since header에 담아서 보낸다.
- 수정을 안해도 되면 304 Not Modified를 보낸다.
- 수정을 해야 하면 200 OK 를 보낸다.



**ETag / If-None-Match**

- ETag에 해시값을 넣어준다.
- 시간과 상관없이 재검증을 할 수 있다.



**Force Revalidation**

Cache-Control : no-cache 를 주면 항상 서버에게 물어본다.

예전에는 Cache-Control: max-age=0, must-revalidate / 하지만 http1.1부터는 필요없다.

no-store를 쓰면 브라우저의 이점을 못살린다.





### 일반적인 캐싱 패턴

**기본 설정**

Cache-Control : no-cache

없으면 휴리스틱 캐시가 발생할 수 있다 / 브라우저가 임의로 지정할 수 있다.



Cache-Control : no-cache, private

개인정보가 있다면 private도 넣어준다.



**캐시 무효화(Cache Busting)**

보통은 js, css 정적 파일을 캐싱하는 것이 좋다. 수정하기 전까지는 절대 바뀌지 않기 때문에, 새로 배포됐을 때만 새로운 값으로 변경되도록 url을 가지도록 한다.

정적파일 이름을 `build.v123.css` 처럼 짓는다.



**재검증(Validation)**

Cache-Control 의 max-age = 31536000 (1년) 로 길게 잡고

Etag를 이용한다.



**Main resources**

Cache-Control : no-cahe, private을 가져간다.

Etag를 써서 서버에서 유효한지 확인을 받는다.







