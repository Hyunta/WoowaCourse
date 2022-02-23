# 📖 TDD로 자동차 경주게임 구현

# TDD로 자동차 경주게임 구현

## 기능 요구사항

- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## TDD 관련 초보자의 한마디

```plaintext
1차로 다이어그램(종이에..) 간단히 그려보고, 
각 도메인마다 테스트를 먼저 작성하면서 진행해봤습니다.
알듯말듯 어렵네요 ㅎㅎ

테스트를 작성하는게 생각보다 힘이 드네요.
어디까지 검증해야할지, 
무엇을 정확히 검증해야 할지 아직 감이 잘 오진 않는 것 같습니다.
다른 도메인과 의존관계가 있는 도메인의 경우 
테스트 범위를 나누기도 조금 힘들었구요

계속 연습하다보면 알게 되겠죠..
```

## 단위 테스트, TDD를 시작할 때의 감정 상태

**어디서, 어떻게 시작해야할지 모르겠다. 막막함**

## 요구사항 분석 및 설계

- 요구사항 분석을 통해 대략적인 설계 - 객체 추출
- UI, DB 등과 의존관계를 가지지 않는 핵심 도메인 영역을 집중 설계

- 1차적으로는 도메인 로직을 테스트하는 것에 집중

![domain.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-L9D5L4Xj_6xjTfOTRks%2Fdomain.PNG?alt=media&token=5083069f-e922-4f0e-95a4-d3fb9fb95224)

- 대략적인 도메인 객체 설계

![domain2.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-L9D5L4Xj_6xjTfOTRks%2Fdomain2.PNG?alt=media&token=f8d287eb-e747-410c-979c-369eb3b26826)

**하지만 난 객체 설계 경험이 많지 않아요.
테스트 가능한 구조의 객체 설계는 일정 수준의 경험이 있는 상태에서만 가능한 거 아닌가요?
난 객체 설계 역량도 부족하고, 단위 테스트도 익숙하지 않고, TDD는 정말 정말 더 힘들어요. ㅠㅠ**

## 구현할 기능 목록 작성하기

- 기능 목록을 작성하는 것도 역량이 필요한 것 아닌가?
- 역량도 중요하지만 **연습이 필요**하다.

## 그래도 막막하다면...

- 단위 테스트도 없고, TDD도 아니고, 객체 설계도 하지 않고, 기능 목록을 분리하지도 않고 **일단 구현**
- 구현하려는 프로그래밍의 **도메인 지식을 쌓는다.**
- **구현한 모든 코드를 버린다.**
- 구현할 기능 목록 작성 또는 간단한 도메인 설계
- 기능 목록 중 가장 만만한 녀석부터 TDD로 구현 시작
- 복잡도가 높아져 리팩터링하기 힘든 상태가 되면 다시 버린다.
- 다시 도전

**아무 것도 없는 상태에서 새롭게 구현하는 것보다**
**레거시 코드가 있는 상태에서 리팩터링하는 것은 몇 배 더 어렵다.**

# TDD로 자동차 경주게임 구현

## 일단 구현

- 지금까지 자신에게 익숙한 방법으로 **일단 구현**

#### 테스트 가능한 부분을 찾아 단위 테스트

- 참여자의 이름 split
- 자동차 이동 유무
- 자동차 이동 거리에 따라 "-" 생성하기

#### 테스트하기 어려운 부분을 찾아 가능한 구조로 개선

- Object Graph에서 다른 Object와 의존관계를 가지는 않는 마지막 노드(Node)를 먼저 찾는다.
- 예를 들어 RacingMain -> RacingGame -> Car와 같이 의존 관계를 가진다면 Car가 테스트 가능한지 확인한다.

```java
public class Car {
    private static final int FORWARD_NUM = 4;

    private int position = 0;

    public void move() {
        if (getRandomNo() >= FORWARD_NUM) {
            this.position++;
        }
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
```

![car1.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar1.png?alt=media&token=8f14912d-1804-48e1-96f8-9bba04191c8c)

![car2.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar2.png?alt=media&token=fc0423f7-6840-4638-8181-c494a0629dd5)

![car3.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar3.png?alt=media&token=5646987c-e744-4937-abcf-98b67fd8c08b)

![car4.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar4.png?alt=media&token=1561da8a-bafb-4cbf-b149-b958ad59ee42)

#### 해결책

- 테스트하기 어려운 코드의 의존관계를 Object Graph의 상위로 이동시킨다.

![car5.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar5.png?alt=media&token=6337ba4c-1bcb-42dd-8335-f953cc11fc7e)

![car6.png](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-Kk9mNZRospN5eO7duC0%2Fcar6.png?alt=media&token=dcabdea9-69b2-4dcf-9f83-fea93208a4b3)

#### 대표적으로 테스트하기 어려운 코드

- 내부 API
  - Random, shuffle, 날짜
- 외부 세계
  - 외부 REST API
  - 데이터베이스 API

## 구현한 모든 코드를 버린다

- 테스트 가능한 구조로 만들기 어려운 상태까지 연습하고 **모든 코드를 버린다.**
- 앞 단계 구현을 통해 도메인 지식을 쌓는다.
- 구현할 기능 목록 작성 또는 간단한 도메인 설계
- 기능 목록 중 가장 만만한 녀석부터 TDD로 구현 시작

## 다시 TDD로 자동차 경주게임 구현 도전

#### TDD로 Car 구현하기

- 정지
- 이동

#### TDD로 우승자 구현하기

- Car에서 최대 위치 구하기
- 최대 위치를 가지는 Car 목록 구하기

#### TDD로 구현한 도메인 객체를 활용해 프로그램 완성

- TDD로 구현하기 힘들다 생각하는 부분은 일단 포기
- 앞 단계에서 TDD로 구현한 객체를 조합해 프로그램 완성

#### 구현한 모든 코드를 버린다

## 다시 TDD로 자동차 경주게임 구현 도전 - 규칙 추가

- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 8: 일급 콜렉션을 쓴다.

#### 규칙 3: 모든 원시값과 문자열을 포장한다.

- Car의 `int position`을 포장하기
- RacingGame의 `int tryNo`를 포장하기

#### 규칙 8: 일급 콜렉션을 쓴다.

- 자동차 목록을 일급 콜렉션으로 구현하기