레벨 인터뷰 목적

- 이전 레벨에 학습한 내용에 대한 자신의 현재 상태를 파악한다.

레벨 로그 작성법

- 형식은 자유
- 레벨 별, 미션 별로 학습한 내용을 A4지 한장 내외로 요약해 작성한다.

---



## 자동차 경주 - TDD

- Random 테스트

  Random 값은 테스트를 방해한다. 자동차는 랜덤값에 의해 4보다 작은 값일 때는 멈추고, 4보다 크거나 같으면 앞으로 이동하는데 테스트하기 번거로웠다. 메서드 시그니처를 수정하여 Random값을 만드는 부분을 분리하니 테스트하기 용이해졌다. 기존 `move()`는 랜덤값을 만드는 기능과 값에 의해 전진할지 말지 결정하는 기능을 갖고 있었다. 메서드가 한가지 기능만 하면 테스트하기 용이해진다.

  ```java
  public void move() {
    final int number = random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    if (number >= MOVABLE_LOWER_BOUND) {
      position++;
    }
  }
  
  
  public void move(int number) {
      if (number >= MOVABLE_LOWER_BOUND) {
          position++;
      }
  }
  ```

- 응집성이 높고, 결합도가 낮은 코드

  기능을 수행하기 위해 연관된 책임과 아이디어가 뭉쳐있고, 다른 모듈에 의존성이 낮도록 설계하는 것이 좋다. 유지보수할 때 응집성이 높아야 수정해야할 부분을 알 수 있고, 결합도가 낮아야 적게 변경할 수 있다.

  `Car` 와 `CarValidator` 를 별도로 두게되면 응집성이 낮고 결합도가 높아진다. 따라서 Car의 검증은 Car 내부에서 하는 것이 바람직하다고 생각한다.

- 전략 패턴

  ```java
  public void startEachRace() {
    for (Car car : cars) {
      car.move(makeRandom()
  	}
  }
  
  private int makeRandom(){
    Random random = new Random();
    return random.nextInt(MAX_BOUND - MIN_BOUND + 1) + MIN_BOUND;
  }
  ```

  해당 메서드를 어떻게 테스트할 수 있을까? 매 경기가 시작되면 자동차에 랜덤값을 넘겨주면서 움직이도록 한다. 지금 상태로 테스트를 하게되면 매번 다른 결과가 나온다. 여러 고민을 하다가 랜덤으로 숫자를 만드는 로직을 분리하기로 했다. 전략 패턴을 이용하여 NumberGenerator 라는 인터페이스의 구현체를 이용했다. RandomNumberGenerator를 주입해서 테스트할 때는 FixedNumberGenerator로 테스트를 했다.

  ```java
      public void startEachRace(NumberGenerator numberGenerator) {
          for (Car car : cars) {
              car.move(numberGenerator.generateNumber());
          }
      }
  ```



## 로또 미션 - OOP

- @MethodSource 활용

  ```java
      @ParameterizedTest
      @DisplayName("등수를 올바르게 결정하는지 확인")
      @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH",
              "4:true:FOURTH", "3:true:FIFTH", "3:false:FIFTH"}, delimiter = ':')
      void valueOf(int sameCount, boolean bonus, LottoRank expectedLottoRank) {
          LottoRank lottoRank = LottoRank.valueOf(sameCount, bonus);
          Assertions.assertThat(lottoRank).isEqualTo(expectedLottoRank);
      }
  ```

  Enum 값을 변경하면서 Test 코드를 전부다 수작업으로 변경해야하는 상황이 생겼다. 이런 일을 안만들기 위해서 하드코딩이 아니라 로컬 변수로 지정할 수 있도록 변경했다. 이때 @MethodSource를 사용하게 되면 아래와 같이 해결할 수 있다.

  ```java
  @ParameterizedTest
  @DisplayName("등수를 올바르게 결정하는지 확인")
  @MethodSource("rankParameterProvider")
  void valueOf(int sameCount, boolean bonus, LottoRank expectedLottoRank) {
      LottoRank lottoRank = LottoRank.valueOf(sameCount, bonus);
      Assertions.assertThat(lottoRank).isEqualTo(expectedLottoRank);
  }
  
  private static Stream<Arguments> rankParameterProvider() {
      return Stream.of(
              Arguments.arguments(6, false, FIRST),
              ...
      );
  }
  ```

- null이 아닌 의미있는 값으로 반환하자.

  로또 순위에 들지 못했을 경우 null을 반환하도록 구현했었는데, 에러가 났을 경우와 헷갈릴 수 있다. 초기화 되지 않거나 버그로 null이 반환되는 경우와 구분할 수 없다. 따라서 당첨되지 않은 사람들을 위한 enum을 생성해서 반환하도록 변경해줬다.

- MVC 패턴

  MVC 패턴으로 구현했을 때 핵심은 각 컴포넌트가 서로에 대해서 몰라야한다. 모델은 어떻게 출력할지 관심이 없고, 컨트롤러는 비지니스 로직과 입출력값에 책임을 지면 안된다. 뷰 또한 비지니스 로직을 모르도록 해야한다.



## 블랙잭 - 상속, 인터페이스

- 상속

  추상 클래스와 인터페이스를 이용해서 상속할 수 있다. 상속을 통해서 중복을 제거한다. 메서드를 추상화해서 구체 클래스에서 공통 부분을 묶어낼 수 있다.

- 인스턴스 캐싱

  자주 사용하는 인스턴스는 미리 만들어서 캐싱해두는 것이 유리하다. 트럼프 카드 같은 경우 같은 카드를 계속 생성해야하므로,  미리 캐싱해두고 카드덱에서 가져가 생성할 수 있도록 구현했다.

- 인스턴스 변수는 언제 초기화하는게 좋을까?

  생성자, 변수 선언, 초기화 블럭 3가지 방법이 있는데 생성자를 제외하고 코드 순서에 영향을 받는다. 나는 생성자에서 초기화하는 것이 좋다고 생각한다.

- 상태패턴

  객체 내부 상태 변경에 따라 객체의 행동이 달라지는 패턴. 블랙잭의 경우 각 참가자의 카드에 따라 상태를 변경하여 행동을 제한할 수 있다.

