## Git rebase로 커밋 히스토리 관리하기(이상우, 김수현)

git rebase

What is merge?

merge: 두개의 브랜치가 하나로 이어지는 것을 말한다

rebase: 가지가 여러가지 있지만 잘라서 이어서 붙인다.

git rebase master

![image-20220323200543571](/Users/kimhyuntae/Library/Application Support/typora-user-images/image-20220323200543571.png)







## Git on LazyGit(김태현, 변치호)

구글 드라이브는 저장한 시점을 통해서 복원할 수 있다.

어느 순간 버전이 생성되어있기 때문에 평소 생활할 때 쓰기 좋은 상황

구글 드라이브처럼 마음대로 만들어지면 안된다!



개발자가 자기가 원하는 시점에 버전을 만들 수 있는 관리도구!

깃은 변경을 하더라도, 깃을 통해 관리를 할거라고 알려주지 않는 이상 바뀌지 않는다

unstaged 상태

변경 상태를 unstaged -> staged로 변경해야 한다

add : unstaged -> staged

commit : staged -> commit 

staged상태인 변경 사항들을 모두 특정 버전으로 찍어내빈다.

하나의 버전으로 만들어내는 것을 commit이라 한다.



Local Repository: 내 컴퓨터에 있는 저장소

Remote Repository: 원격 저장소, 공유하는 repository



브랜치 생성하기

git checkout -b <브랜치 이름>

git branch <브랜치 이름>



git push origin my-branch





## 개울에서 바다로 -간단한 GitHub 프로젝트에 직접 기여해보고 upstream 과 fork의 개념을 맛보기 -‘커밋은 왜 할까? 좋은 커밋이 있을까?’ 얘기해보기 이한규-박송희

git upstream, fork

fork를 받아서 수정을 하고 다시 upstream을 통해서 거슬러 올라 반영할 수 있도록 하는 것!





---



## GitFlow

2010년에 Vincent Driessen 블로그 글이 퍼지면서 유행

각자의 팀 상황, 업무 상황에 따라 적합한 것을 선택하는 것이 바람직함

개념적으로 브랜치를 나눠서 진행하는 것

master에서는 tag를 이용해서 받아온다.

기능을 개발할 때 feature branch를 이용한다.

upstream first 정책



## Git에서 보안 문서를 유출했을 경우

git 해당 파일들의 작업을 조율하기 위한 분산 버전 관리 시스템

gitHub 웹 저장소

민감 데이터 - sensitive data

db 패스워드, aws 노출된 키

사고를 수습하고 어떻게 할 것인지?

.gitignore를 사용한다!





