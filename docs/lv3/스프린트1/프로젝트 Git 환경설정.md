

## 학습 동기

레벨3가 시작되고 `꼭꼭` 프로젝트가 시작됐다. Git 브랜칭 전략, Issue Template, PR Template, Git Commit Message 관련 설정해야할 것들이 너무 많았다. 프로젝트를 처음 진행해보니 어떤 일이 진행되는지 잘 이해가 안갔었다. 오늘 어느정도 세팅이 완료됐는데 이제는 대략적으로 파악이 되서 하나씩 정리해보려고 한다.



## Git 환경설정

### PR Template

`<프로젝트 디렉토리>/.github/` 위치에 PULL_REQUEST_TEMPLATE.md 라는 파일을 만든다. 이후 PR을 등록하면 템플릿 문자열이 기본적으로 등록된다.

```
PULL_REQUEST_TEMPLATE.md

## 내용
* 구현한 기능을 작성합니다.

Close #이슈번호
```



<img src="/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701211640023.png" alt="image-20220701211640023" style="zoom:50%;" /> 

### Issue Template

`<프로젝트 디렉토리>/.github/ISSUE_TEMPLATE/` 해당 위치에 markDown 파일을 만들어두면 이슈를 등록할 때 템플릿 처럼 사용할 수 있다.

```
be_feature_request_template.md

---
name: be_feature_request.md
about: feature
title: "[BE] "
lables: feature
assigness: ''

---

## 설명

* 기능에 대한 설명

## 진행사항

- [ ] 할일1


## 주의사항

* 주의사항에 대한 설명
```

여러개의 Issue Template을 작성해두면 선택해서 사용할 수 있다.

![image-20220701212115917](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701212115917.png)

![image-20220701212142411](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701212142411.png)



두 가지 설정을 해두면 Issue 템플릿을 통해 해야할 일 들에 대한 Issue를 생성하고, PR Template을 활용하여 개발이 마친 뒤 팀원들에게 PR을 보낼 때 보내는 내용들의 컨벤션을 맞출 수 있다.



### Label

Issue에 대해서 Label을 통해 관리하면 어떤 일을 진행하고 있는지 카테고리로 분류할 수 있다. 하나의 레포지토리를 이용해서 프론트엔드와 백엔드가 협업하다보니 라벨을 통해 파트별로 처리해야할 업무들을 조회할 수 있다. 

<img src="/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701212504819.png" alt="image-20220701212504819" style="zoom:50%;" />

![image-20220701212532774](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701212532774.png)



### GitHub Project 생성

팀원끼리 칸반보드를 공유하기 위해서 Github에서 제공하는 Projects를 이용했다. Sprint를 시작할 때 Issue들을 ToDo에 등록한다. 각자 업무를 맡아서 진행할 때 In progress에 위치시킨다. 해당 업무가 마무리됐을 때 PR을 보내고 PR에 `close # <이슈번호>` 를 작성해서 올리면 자동으로 Issue와 링크가 된다. PR이 merge 되면 자동으로 Done으로 이동한다.

![image-20220701212823990](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701212823990.png)



+추가로 `꼭꼭`팀은 칸반보드를 주간과 일간으로 나눠서 관리한다. 아래 이미지 처럼 노션을 이용해서 대략적인 스프린트 기간동안의 업무를 작성하고 GitHub 칸반 보드를 이용해서 데일리 스크럼 때 업무를 분담한다.

![image-20220701214011017](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220701214011017.png)



### Commit Message Convention

- feat

  : 기능 추가(새로운 기능) O, 기능 변경 O

  - ex) feat: 노선의 구역 추가 기능 구현
  - ex) feat: 노선의 구간 추가 기능 삭제
  - ex) feat: 노선의 구역 동시 추가 기능 구현
  - ex) feat: 노선의 상세 설명을 추가하는 기능 구현

- refactor

  : 기능 변경 x, 코드 수정 O

  - Input, Output이 동일하고 내부 구현 코드만 변경된 경우
    - 의존성 제거, 의존성 추가
    - JdbcTemplate → JPA
    - JavaScript → TypeScript
  - `style:` 의 영역이였던 코드 컨벤션 적용도 refactor로 포함
  - ex) refactor: Sections의 value 필드 타입을 List에서 HashMap으로 수정

- test

  : 테스트만 수정되는 경우

  - ex) test: SectionDao 구간 추가 기능 테스트 코드 수정
  - ex) test: SectionDao 구간 추가 기능의 역 검증 수정
  - ex) test: SectionDao 구간 추가 기능의 누락된 테스트 코드 구현

- fix

  : 버그 수정 O(의도한 생각이랑 결과가 다를 경우), 코드 수정 O

  - ex) fix: SectionDao 구간 추가시 지하철 역이 삭제되는 문제 수정

- chore

  : 기능 변경 x, 코드 수정 x, 환경 설정(개발 기능) O

  - ex) chore: 백엔드 프로젝트 기본 설정

- docs

  : 문서 추가(template, docs) O

  - ex) docs: issue, pr template 설정
  - ex) docs: pr template의 title 수정
  - ex) docs: 구간 등록의 요구사항 수정