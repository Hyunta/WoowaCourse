### **백엔드 요구사항**

- 쉘 스크립트 또는 CI 도구를 활용한 배포 자동화



https://artist-developer.tistory.com/24



---

https://www.youtube.com/watch?v=0Emq5FypiMM

## CI/CD 5분 개념 정리 (현업에서 쓰는 개발 프로세스)



지속적인 통합 + 지속적인 제공 or 배포

버그 수정 or 새로 만드는 기능이 main Repository 에서 계속 개발 및 배포하는 것이 가능



Continuous Integration 개발 원칙

1. 코드 변경사항을 주기적으로 빈번하게 머지해야한다.
   - 최대한 작은 단위로 나눠서 개발하고 통합한다.
2. 통합을 위한 단계의 자동화
   - 빌드 - 테스트 - 머지 가 자동으로 되어야 합니다!
   - 개발팀에서 setUp을 합니다.
   - PR 보낸것이 머지가 되면 -> CI Script에서 Build가 되고 Test가 잘되면 -> 통과 후 배포에 반영
   - 개발한 단위에 대한 unitTest가 있어야 하기 때문에 조금 더 안정성 있는 개발이 가능하다



Continuous Delivery 와 Deployment

1. 지속적인 제공

   CI 된 결과물 -> 릴리즈 준비 -> 릴리즈 배포

   회사 마다 다르다 / CICD라고 해도 다를 수 있다 / 팀마다 다름



Jenkins, BuildKite, GitHub Actions 등



---

## 제발 깃허브 액션🔥 모르는 개발자 없게해 주세요 🙏

https://www.youtube.com/watch?v=iLqGzEkusIw

개발 프로세스의 핵심 -> 자동화

2018년에 GitHub Action을 통해 자동 CI CD가 가능하다.

Events -> workflows -> jobs -> actions -> Runners



---

## [CI/CD] Jenkins 과 GitHub Actions의 개념, 차이점

https://choseongho93.tistory.com/295



![image-20220710173841763](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220710173841763.png)

---



# [토크ON세미나] Jenkins를 활용한 CI/CD 1강 - 젠킨스(Jenkins) 이해 | T아카데미

https://www.youtube.com/watch?v=JPDKLgX5bRg



개발한 프로덕트를 QA, PRDO 등으로 구성하는 것도 말한다.

Jenkins의 기본 개념에 대해 이해한다. 파이프 라인을 통해서 어떻게 배포하는 것인지 소개



### 1. CI/CD 란 무엇인가?

지속적인 통합(여러 개발자들의 코드베이스를 계속해서 통합) + 지속적인 배포

궁극적으로 코드만 작성했는데, 누군가 내꺼를 쓰고 있더라 (자동화)



CI/CD란 개발자들이 개발을 하는 환경을 사용자가 사용 가능한 서비스로 전달하는 모든 과정을 자동화

코드 작성 -> 빌드 -> 테스트 -> 배포 PipeLine



#### CI 왜 필요한가?

10명의 개발자가 열심히 개발 이후 Conflict난다 / 한번에 합치는데 일이 너무 많이 생긴다.

#### CD는 왜 필요한가?

배포 스크립트 작성, AWS 배포 등등 / 개발자는 코드만 작성하면 된다.



### 2. 젠킨스의 기본 개념과 동작 방식

Java Runtime 위에서 동작하는 자동화 서버 아니면 Docker Image로 받아서 가능

다양한 플러그인들을 활용해서 각종 자동화 작업을 처리할 수 있음

일련의 자동화 작업의 순서 Pipe라인을 구성



대표적인 PlugIn / Credential, Git Plugin

Git access Token, AWS Token 등 중요한 정보를 저장해 주는 플러그인

실제 환경에는 Private 서버에서 관리하므로 보안에 유리하다.



# [토크ON세미나] Jenkins를 활용한 CI/CD 2강 - 젠킨스 개발환경 및 CI/CD 기본 동작 이해 | T아카데미

https://www.youtube.com/watch?v=3WZoVkvLE4A



개발 환경 종류에는 무엇이 있을까?

Local, Dev, QA 환경, Production 환경 / DEV QA PROD 환경이라 부르자



### 여러 배포 환경의 관리









