```java
    public void startEachRace(int minBound, int maxBound) {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateNumber(minBound, maxBound));
        }
    }
```

현재 컨트롤러에서 `startEachRace(RANDOM_MIN_BOUND, RANDOM_MAX_BOUND)` 와 같이 구현되어있어서 숫자가 랜덤으로 생성된다는 내부 로직을 알고 있다. 그리고 숫자 생성 범위를 외부에서 제어한다는 문제점을 갖고 있다. 이를 어떻게 해결하는게 좋을까?

우선 숫자의 생성 범위를 컨트롤러에서 제어하는 건 문제가 된다. 테스트를 위해서 구성을 했었기 때문에 변경했어야 했다. 하지만 Random으로 숫자를 생성한다는건 컨트롤러에서 알아도 상관없다고 생각했다. 그래서 전략패턴을 이용해서 RandomNumberGenerator를 구현체처럼 사용했다. 해당 메서드를 아래와 같이 변경하여 테스트에 용이하게 만들었다.

```java
    public void startEachRace(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generateNumber());
        }
    }
```

테스트할 때는 새로운 구현체를 만들어서 항상 전진하는 경우와 전진할 수 없는 경우를 나눠서 진행했다.