## 학습 동기

자바로 DB에 접근할 때 DAO 클래스를 이용했다. 테이블마다 Dao를 만들어서 Connection을 통해 쿼리문을 전달하여 원하는 값을 받아오는 용도로 Data Access Object라는 명명을 이용했다. 스프링으로 전환을 하면서 @Repository 애노테이션을 사용하면서 Dao라는 이름을 가지는게 어색하다고 생각하여 Repository로 변경했는데 둘의 차이를 모호하게 알고 있는 것 같아서 공부해봤다.



## Dao vs Repository

### 1. DAO Pattern

DAO(Data Access Object) 패턴은 DB의 내용을 추상화한 것이다.

도메인보다 DB에 더 가까운 것으로 생각한다. 따라서 DAO는 DB 테이블과 일차하는 경우가 많다. 

CRUD를 하기 위한 복잡한 쿼리는 내부적으로 감춘다.

```java
public interface UserDao {
    void create(User user);
    User read(Long id);
    void update(User user);
    void delete(String userName);
}
```



### 2. Repository Pattern

도메인과 Data Mapping Layer 사이를 중재한다.

Repository는 객체의 Collection을 다루듯이 인터페이스를 제공한다는 점에서 DB 테이블보다 객체 중심의 Layere다.

Repository로 다루는 객체를 다루기 위해서 여러 테이블에 접근해야 한다면, 여러 DAO를 사용할 수 있는 것이다.

```java
public interface UserRepository {
    User get(Long id);
    void add(User user);
    void update(User user);
    void remove(User user);
}
```



### 3. Repository가 여러 DAO를 가지는 구조

Dao와 Repository를 완전히 분리해서 사용해야하는 것은 아니다. 일반적으로 Dao는 DB에 접근하는 CRUD를 구현하고 Repository는 도메인과 DB사이에서 조금 더 도메인과 연관된 높은 단계에 있으므로 같이 사용할 수 있다.

Repository에서 여러 테이블에 접근을 해야할 때 Dao를 여러개 주입받아서 아래와 같이 사용할 수 있다.

```java
public class UserRepositoryImpl implements UserRepository {
    private UserDaoImpl userDaoImpl;
    private TweetDaoImpl tweetDaoImpl;
    
    @Override
    public User get(Long id) {
        UserSocialMedia user = (UserSocialMedia) userDaoImpl.read(id);
        
        List<Tweet> tweets = tweetDaoImpl.fetchTweets(user.getEmail());
        user.setTweets(tweets);
        
        return user;
    }
}
```



### 정리

DAO는 DB와 가까운 CRUD 로직을 구현할 때 사용하고, Repository는 객체를 DB와 연결지을 때 사용하자.



#### Reference

https://www.baeldung.com/java-dao-vs-repository