# 📖 TDD, 리팩터링이란?

# Test Driven Development(테스트 주도 개발, TDD)

## 용어 정리

![main_test.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-KtjhuyrC6mMND3m57bq%2Fmain_test.PNG?alt=media&token=c25514e2-6e59-49c0-bd92-de58dbb8c1c3)

- 위 그림을 통해 확인할 수 있듯이 **프로덕션 코드(Production Code)** 프로그램 구현을 담당하는 부분으로 사용자가 실제로 사용하는 소스 코드를 의미한다.
- **테스트 코드(test code)** 는 프로덕션 코드가 정상적으로 동작하는지를 확인하는 코드이다.

## TDD란?

- TDD = TFD(Test First Development) + 리팩터링
- TDD란 프로그래밍 의사결정과 피드백 사이의 간극을 의식하고 이를 제어하는 기술이다. - 켄트벡, Test Driven Development by Example 중
- TDD의 아이러니 중 하나는 테스트 기술이 아니라는 점이다. TDD는 분석 기술이며, 설계 기술이기도 하다. - 켄트벡, Test Driven Development by Example 중

## TDD를 하는 이유

- 디버깅 시간을 줄여준다.
- 동작하는 문서 역할을 한다.
- 변화에 대한 두려움을 줄여준다.

## TDD 사이클

![tdd cycle](https://articles.tbscg.com/wp-content/uploads/2015/11/tdd-cycle.png)

- 실패하는 테스트를 구현한다.
- 테스트가 성공하도록 프로덕션 코드를 구현한다.
- 프로덕션 코드와 테스트 코드를 리팩터링한다.

## TDD 원칙

- 원칙 1 - 실패하는 단위 테스트를 작성할 때까지 프로덕션 코드(production code)를 작성하지 않는다.
- 원칙 2 - 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
- 원칙 3 - 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

# 나는 왜 TDD에 집착하는가?

## 1. 나는 사람이다.

요구사항 추가, 변경 때문에 소스 코드를 수정하고 불안감에 살고 싶지 않다.

![img](https://pbs.twimg.com/media/DKzTYhDUQAA_7q2.jpg)

사람답게 살고 싶다.

## 2. 나는 평범하다.

한 번에 한 가지만 집중할 수 있다.

![tdd cycle](https://articles.tbscg.com/wp-content/uploads/2015/11/tdd-cycle.png)

- Test fails => Test passes
  - 입력, 출력에 집중
  - 로직을 구현하는 것에 집중
  - 테스트를 통과하기 위해 어떠한 행위도 허용
- **심적으로 안정감을 얻을 수 있다.**
- 리팩토링
  - 설계
  - 클린 코드

처음부터 완벽한 설계를 하는 것이 아니라
**점진적으로 설계**를 개선해 나갈 수 있다.

- 변화에 빠르게 대응할 수 있는 소스 코드와 연습
- **과도한 설계(Overengineering)에 따른 추가 비용을 해소**

## 3. 나는 프로그래밍을 좋아한다.

![no_unit_test.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-L8eBiLe5_2QgYFJGIfx%2Fno_unit_test.PNG?alt=media&token=396f34bf-58db-433b-9b00-92996c2a904b)

![unit_test_1st.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-L8eBiLe5_2QgYFJGIfx%2Funit_test_1st.PNG?alt=media&token=3d5eef46-dbca-4102-b8eb-d6835a4c084c)

![unit_test_2nd.PNG](https://firebasestorage.googleapis.com/v0/b/nextstep-real.appspot.com/o/lesson-attachments%2F-L8eBiLe5_2QgYFJGIfx%2Funit_test_2nd.PNG?alt=media&token=b1448883-a71d-4068-9b08-9f3bd699fc2e)

#### 빠른 피드백을 통한 개발 효율

- 버그를 찾는 시점이 빨라짐.
- 일정한 리듬으로 일함으로써 프로그래밍에 재미를 느낌
- 더 많은 삽질을 할 수 있음. 삽질은 더 많은 배움

# TDD, 리팩토링 적용 효과

## 서비스 안정성이 높아짐

- 버그 발생 가능성이 줄어든다.
- 코드 품질이 높아져 변화에 좀 더 빠르게 대응할 수 있다.

## 개발자들의 역량 강화

- 학습 효율이 높아져 개발자의 역량을 높일 수 있다.
- 개발자의 만족도가 높아져 이직율이 낮아질 수 있다.

**수동 테스트, 배포에 대한 부담을 줄이면서 핵심 비지니스 로직 구현에 집중**

지금 필요한 것은 새로운 접근방식에 도전할 수 있는 **용기**