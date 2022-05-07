테스트를 접하면서 사용법과 활용 방법을 간접적으로 체험

웹 애플리케이션을 만들 때는 어떤 테스트가 있는지 알아볼게요!

대표적으로 Junit Test

@SpringBootTest - webEnvironment 종류

미션에서 권장하는 테스트 방법은 실제 웹 환경과 같은 곳에서 테스트 하는 것

Test 서버를 띄우고 RestAssured를 띄워서 확인해 보는 것으로 하자

Test Slices

https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html#appendix.test-auto-configuration

####  통합 테스트와 고립 테스트

통합 테스트: 연관된 객체라면 같이 쓰자

고립 테스트: 연관 없이도 잘 작동해야지(Mock같은 가짜 객체를 주입한다.)

>Mock객체
>
>테스트에서 필요없는 값을 대신 반환해주는 도구



End to End Test:

끝에서 끝까지 확인을 해보는 테스트이다!

브라우저까지 갔다가 잘 렌더링 되는지 확인해보는 테스트 (UI단도 확인해본다)

Selenium - 브라우저까지 잘 동작하는지 확인하는 테스트

단위 테스트 vs 통합 테스트 vs 인수 테스트

https://tecoble.techcourse.co.kr/post/2021-05-25-unit-test-vs-integration-test-vs-acceptance-test/



DataJDBC

```
org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration` `org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration` `org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration` `org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration` `org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration` `org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration` `org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration
```



JDBC

```
org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration` `org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration` `org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration` `org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration` `org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration` `org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration` `org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration
```
