- ๐ JPA Hands-on Part 1

  # ๋ค์ด๊ฐ๊ธฐ ์ ์

  ## ๋ง์ ํํธ์๋...

  - ๋ค์นด๋ผ๋ฐฐ๋ JPA๋ฅผ ์ด๋ค๋๋ผ
  - ๊ฐ์ฒด ๊ทธ๋ํ๋ฅผ ๋ชป ๊ทธ๋ ค? ๊ฐ์  ์ฐธ์กฐ?
  - A๊ฐ ์ญ์ ๋๋ฉด `FUNํ๊ณ  COOLํ๊ณ  SEXYํ๊ฒ` A'๋ ์ญ์ ํด ์ฃผ์ธ์.

  ## Spring Data JDBC

  - If you load an entity, SQL statements get executed. Once this is done, you have a completely loaded entity. No lazy loading or caching is done.
  - If you save an entity, it gets saved. If you do not, it does not. There is no dirty tracking and no session.
  - There is a simple model of how to map entities to tables. It probably only works for rather simple cases. If you do not like that, you should code your own strategy. Spring Data JDBC offers only very limited support for customizing the strategy with annotations.

  ?: ๋ ๋ค ๋๋๋ฐ?

  ## ํ์ต ๋ก๋๋งต

  - [ํ ํฌON 41์ฐจ. JPA ํ๋ก๊ทธ๋๋ฐ ๊ธฐ๋ณธ๊ธฐ ๋ค์ง๊ธฐ | T์์นด๋ฐ๋ฏธ](https://www.youtube.com/playlist?list=PL9mhQYIlKEhfpMVndI23RwWTL9-VL-B7U)
  - [์๋ฐ ORM ํ์ค JPA ํ๋ก๊ทธ๋๋ฐ (๊น์ํ ์  | ์์ด์ฝ์ถํ์ฌ)](http://www.yes24.com/Product/Goods/19040233)
  - [์ธํ๋ฐ - ๊น์ํ](https://www.inflearn.com/courses?s=๊น์ํ)
  - [์์์ฑ ์ปจํ์คํธ๋ก ๋ณด๋ JPA](https://www.slideshare.net/ssusere4d67c/jpa-56081624)

  # ํ์ด์

  ## ๊ฐ์ฒด ์งํฅ ํจ๋ฌ๋ค์

  - ์์คํ์ ๊ตฌ์ฑํ๋ ๊ฐ์ฒด๋ค์๊ฒ ์ ์ ํ ์ฑ์์ ํ ๋นํ๋ ๊ฒ
  - ์์
  - ์ฐ๊ด ๊ด๊ณ
    - ๊ฐ์ฒด์ ์ฐ๊ด๊ด๊ณ์๋ ๋ฐฉํฅ์ฑ์ด ์๋ค.
    - ํ์ด๋ธ์ ์ฐ๊ด๊ด๊ณ๋ ๋ฐฉํฅ์ฑ์ด ์๋ค.

  - ๊ฐ์ฒด๋ ์์ ๋กญ๊ฒ ๊ฐ์ฒด ๊ทธ๋ํ๋ฅผ ํ์ํ  ์ ์์ด์ผ ํ๋ค.
  - 

  ```java
  class Line {
      Long id;
      String name;
      Set<LineStation> stations;
  }
  
  class LineStation {
      Station preStation;
      Station station;
  }
  
  class Station {
      Long id;
      String name;
  }
  ```

  ## SQL์ ์ง์  ๋ค๋ฃฐ ๋ ๋ฐ์ํ๋ ๋ฌธ์ ์ 

  ### ๋ฐ๋ณต ์์

  - ์๋ก์ด ํ๋๊ฐ ์ถ๊ฐ๋๋ฉด ๊ด๋ จ๋ SQL์ ๋ค ์์ ํด์ผ ํ๋ค.

  ```java
  class Station {
      Long id;
      String name;
  }
  INSERT INTO station(`id`, `name`) VALUES ...
  SELECT `id`, `name` FROM station
  UPDATE station SET ...
  ```

  ### ์ ๋ขฐ์ฑ

  - ๊ฐ๋ฐ์๋ค์ด ์ํฐํฐ๋ฅผ ์ ๋ขฐํ๊ณ  ์ฌ์ฉํ  ์ ์๋ค.

  ```java
  class LineService {
      private LineRepository lines;
      
      public class LineService(LineRepository lines) {
          this.lines = lines;
      }
      
      public void findLineWithStationsById(Long id) {
          Line line = lines.findById(id);
          line.getLineStation()
                  .stream()
                  .map(LineStation::getStation)
                  .collect(Collectors.toList()); // ?
      }
  }
  ```

  # JPA

  ## ORM

  - [๋ฒ๊ณ ๋, ์์ฃผ์บ์ ORM vs SQL Mapper vs JDBC](https://t1.daumcdn.net/liveboard/cineplay/4c5b90feecb24cdeba43e13db1dc67fb.jpg)
  - [์๋ง์ฐ์ ORM vs SQL Mapper vs JDBC](https://youtu.be/VTqqZSuSdOk)
  - [ORM vs SQL Mapper vs JDBC - ์ฝ์ฆ](https://youtu.be/mezbxKGu68Y)

  ![comment.png](https://techcourse-storage.s3.ap-northeast-2.amazonaws.com/5651d97336ee4f37a89dcc5e008f0747)

  

  ๋ ์ด์์ ์์ธํ ์ค๋ช์ ์๋ตํ๋ค.

  ## ๋ฐ์ดํฐ๋ฒ ์ด์ค ์คํค๋ง ์๋ ์์ฑ

  - `schema.sql`?
  - JPA๋ ๋ฐ์ดํฐ๋ฒ ์ด์ค ์คํค๋ง๋ฅผ ์๋์ผ๋ก ์์ฑํ๋ ๊ธฐ๋ฅ์ ์ง์ํ๋ค.
  - ์๋ ์์ฑ์ ์ถ๊ฐํ๋ฉด ์ ํ๋ฆฌ์ผ์ด์ ์คํ ์์ ์ ๋ฐ์ดํฐ๋ฒ ์ด์ค ํ์ด๋ธ์ ์๋์ผ๋ก ์์ฑํ๋ค.
    - `spring.jpa.hibernate.ddl-auto=create`

  ```
  create: ๊ธฐ์กด ํ์ด๋ธ ์ญ์  ํ ๋ค์ ์์ฑ (DROP + CREATE)
  create-drop: create์ ๊ฐ์ผ๋ ์ข๋ฃ์์ ์ ํ์ด๋ธ DROP
  update: ๋ณ๊ฒฝ๋ ๋ถ๋ถ๋ง ๋ฐ์ (์ด์ DB์ ์ฌ์ฉํ๋ฉด ์๋)
  validate: entity์ table์ด ์ ์ ๋งคํ๋์๋์ง๋ง ํ์ธ
  none: ์ฌ์ฉํ์ง ์์
  ```

  ```
  @Entity // (1)
  @Table(name = "station") // (2)
  public class Station {
      @Id // (3)
      @GeneratedValue(strategy = GenerationType.IDENTITY) // (4)
      private Long id;
  
      @Column(name = "name", nullable = false) // (5)
      private String name;
      
      protected Station() { // (6)
      }
  }
  ```

  

  1. ```
     @Entity
     ```

     - ์ํฐํฐ ํด๋์ค์์ ์ง์ ํ๋ฉฐ ํ์ด๋ธ๊ณผ ๋งคํ๋๋ค.
     - DDD์ ์ํฐํฐ์ ๋ค๋ฅธ ์๋ฏธ๋ค.

  2. ```
     @Table
     ```

     - ์ํฐํฐ๊ฐ ๋งคํ๋  ํ์ด๋ธ์ ์ง์ ํ๊ณ  ์๋ต ์ ์ํฐํฐ ํด๋์ค ์ด๋ฆ๊ณผ ๊ฐ์ ํ์ด๋ธ๋ก ๋งคํ๋๋ค.
     - ๊ตณ์ด ์ ์ธํ์ง ์์๋ ๋๋ค.

  3. ```
     @Id
     ```

     - ์ง์  ๋งคํํด์ ์ฌ์ฉํ๋ ๊ฒฝ์ฐ
     - JPA๋ PK ๊ฐ ํ์๋ค.

  4. ```
     @GeneratedValue
     ```

     - PK์ ์์ฑ ๊ท์น์ ๋ํ๋ธ๋ค.
     - `strategy = GenerationType.Identity` = MySQL์ AutoIncrement

  5. ```
     @Column
     ```

     - ์ปฌ๋ผ์ ์ด๋ฆ์ ์ด์ฉํ์ฌ ์ง์ ๋ ํ๋๋ ์์ฑ์ ํ์ด๋ธ์ ์ปฌ๋ผ์ ๋งคํํ๋ค.
     - ๊ตณ์ด ์ ์ธํ์ง ์์๋ ๋๋ค.

  6. ๋งค๊ฐ ๋ณ์๊ฐ ์๋ ์์ฑ์

     - The entity class must have a no-arg constructor. The entity class may have other constructors as well. - JSR 338
     - ๊ณต๋ถ๋ฅผ ํด๋ณด๋ฉด ์๊ฒ์ด๋ค, LazyLoading๊ฐ ํ๋ก์์ ์ฐ๊ด๋ ํค์๋์ด๋ค.

  ## ์ค์ต

  - `spring.jpa.properties.hibernate.format_sql=true`์ `spring.jpa.show-sql=true`๋ฅผ ์ถ๊ฐํ์ฌ ์ฝ์์ ์คํ๋๋ ํ์ด๋ธ ์์ฑ DDL์ ์ถ๋ ฅํด ๋ณด์.

  ```sql
  create table station (
      id bigint generated by default as identity,
      name varchar(255) not null,
      primary key (id)
  )
  ```

  # Spring Data JPA

  ## Spring Data JPA๋ฅผ ์ฐ๊ธฐ ์ 

  - ๋๋ค์ ๋ฐ๋ณต ์์

  ```java
  class StationRepository {
      void save(Station station) {...}
      Station findById(Long id) {...}
      List<Station> findAll() {...}
      Station findByName(String name) {...}
  }
  ```

  ## Spring Data JPA

  ```java
  interface StationRepository extends JpaRepository<Station, String> {
      Station findByName(String name); // (1)
  }
  ```

  1. ๋ฉ์๋ ์ด๋ฆ์ผ๋ก ์ฟผ๋ฆฌ ์์ฑ
     - [Appendix C: Repository query keywords](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords)

  ## ์ค์ต

  - `save()`์ `findByName()`์ ๋ํ ํ์คํธ๋ฅผ ํด ๋ณด์.
  - `logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE`๋ฅผ ์ถ๊ฐํ์ฌ ๋ฐ์ธ๋ ํ๋ผ๋ฏธํฐ๋ฅผ ์ถ๋ ฅํด ๋ณด์.

  

  ์ฟผ๋ฆฌ ํ๋ผ๋ฏธํฐ๋ฅผ ๋ก๊ทธ๋ก ๋จ๊ธฐ๋ ์ธ๋ถ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ ์์คํ ์์์ ์ฌ์ฉํ๋ฏ๋ก, ๊ฐ๋ฐ ๋จ๊ณ์์๋ ํธํ๊ฒ ์ฌ์ฉํด๋ ๋๋ค. ํ์ง๋ง ์ด์์์คํ์ ์ ์ฉํ๋ ค๋ฉด ๊ผญ ์ฑ๋ฅ ํ์คํธ๋ฅผ ํ๊ณ  ์ฌ์ฉํ๋ ๊ฒ์ด ์ข๋ค.

  ```java
  @DataJpaTest
  class StationRepositoryTest {
      @Autowired
      private StationRepository stations;
      
      @Test
      void save() {
          Station expected = new Station("์ ์ค์ญ");
          Station actual = stations.save(expected);
          assertAll(
                  () -> assertThat(actual.getId()).isNotNull(),
                  () -> assertThat(actual.getName()).isEqualTo(expected.getName())
          );
      }
  
      @Test
      void findByName() {
          String expected = "์ ์ค์ญ";
          stations.save(new Station(expected));
          String actual = stations.findByName(expected).getName();
          assertThat(actual).isEqualTo(expected);
      }
  }
  ```

  # ์์์ฑ ์ปจํ์คํธ

  - ์ํฐํฐ๋ฅผ ์๊ตฌ ์ ์ฅํ๋ ํ๊ฒฝ
  - ์ํฐํฐ ๋งค๋์ ๋ก ์ํฐํฐ๋ฅผ ์ ์ฅํ๊ฑฐ๋ ์กฐํํ๋ฉด ์ํฐํฐ ๋งค๋์ ๋ ์์์ฑ ์ปจํ์คํธ์ ์ํฐํฐ๋ฅผ ๋ณด๊ดํ๊ณ  ๊ด๋ฆฌํ๋ค.

  ```plaintext
  - 1์ฐจ ์บ์
  - ๋์ผ์ฑ ๋ณด์ฅ
  - ํธ๋์ญ์์ ์ง์ํ๋ ์ฐ๊ธฐ ์ง์ฐ
  - ๋ณ๊ฒฝ ๊ฐ์ง
  - ์ง์ฐ ๋ก๋ฉ
  ```

  ## ์ค์ต

  - ๋์ผ์ฑ ๋ณด์ฅ ๋ง๋ณด๊ธฐ

  ```java
  @Test
  void identity() {
      Station station1 = stations.save(new Station("์ ์ค์ญ"));
      Station station2 = stations.findById(station1.getId()).get();
      assertThat(station1 == station2).isTrue();
  }
  ```

  ![img](https://media.vlpt.us/post-images/conatuseus/5f4d8c20-d08b-11e9-9f4f-632c92c19a43/image.png)

  ![img](https://media.vlpt.us/post-images/conatuseus/996d15e0-d08d-11e9-9f4f-632c92c19a43/image.png)

  ![img](https://media.vlpt.us/post-images/conatuseus/d39dcef0-d095-11e9-a3f7-3fdb1399ac5a/image.png)

  ## ์ํฐํฐ์ ์๋ช์ฃผ๊ธฐ

  - ๋น์์(new/transient): ์์์ฑ ์ปจํ์คํธ์ ์ ํ ๊ด๊ณ๊ฐ ์๋ ์ํ
  - ์์(managed): ์์์ฑ ์ปจํ์คํธ์ ์ ์ฅ๋ ์ํ
  - ์ค์์(detached): ์์์ฑ ์ปจํ์คํธ์ ์ ์ฅ๋์๋ค๊ฐ ๋ถ๋ฆฌ๋ ์ํ
  - ์ญ์ (removed): ์ญ์ ๋ ์ํ

  ![img](https://www.objectdb.com/files/images/manual/jpa-states.png)

  ## @Transactional

  - ํธ๋์ญ์์ ์ปค๋ฐํ๋ ์๊ฐ ์์์ฑ ์ปจํ์คํธ๋ฅผ ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ๋ฐ์

  ![img](https://media.vlpt.us/post-images/conatuseus/d4a2fb30-d09b-11e9-a657-a958e5af4073/image.png)

  ![img](https://media.vlpt.us/post-images/conatuseus/51c8cae0-d09c-11e9-b275-49c1db32880d/image.png)

  ![img](https://media.vlpt.us/post-images/conatuseus/eb6c9c30-d09c-11e9-b0db-1597a34a142f/image.png)

  ## ์ค์ต

  - ๋ณ๊ฒฝ ๊ฐ์ง ๋ง๋ณด๊ธฐ

  ```java
  @Test
  void update() {
      Station station1 = stations.save(new Station("์ ์ค์ญ"));
      station1.changeName("๋ชฝ์ดํ ์ฑ์ญ");
      Station station2 = stations.findByName("๋ชฝ์ดํ ์ฑ์ญ");
      assertThat(station2).isNotNull();
  }
  ```

  ![img](https://media.vlpt.us/post-images/conatuseus/b5d57200-d0a0-11e9-90a8-3bdc8e61daef/image.png)



๊ธ์์ผ์ ๊น์ง ์ํฐํฐ๋งคํ ๋ฏธ์์ ํด๋ณด์ธ์ / ๊ทธ๋ฆฌ๊ณ  ๊ธ์์ผ๋  ์์์ ๋ฃ๊ณ  2๋จ๊ณ๋ฅผ ์งํํด๋ณด๊ณ  / 3๋จ๊ณ๋ฅผ ํด๋ณด์ธ์