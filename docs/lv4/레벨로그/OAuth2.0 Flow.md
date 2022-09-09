![OAuth 2.0 동작과정 시퀀스 다이어그램](https://hudi.blog/static/7dced69214d91d7f1f0892720b1b5e1b/ca1dc/oauth2.0-process.png)

1. 사용자가 서비스에 로그인 요청을 한다.
2. Client는 ClientId, Redirect URI, ResponseType을 Authorization Server에 보낸다.
3. 사용자에게  로그인 페이지를 보여준다
4. 해당 AuthorizationServer(ex. github, goole etc)에 로그인을 한다
5. AuthorizationCode를 발급한다.
6. AuthorizationCode를 RedirectURI로 리다이렉트 시킨다.
7. AuthorizationCode, ClientId, Client-Secret을 이용해 AccessToken을 요청한다.
8. AccessToken을 발급받는다.
9. 초기 사용자일 경우 회원가입 시키고, 기존 회원일 경우 정보를 업데이트 한다. 이후 사용자에게 Token을 만들어서 제공한다.