### 매트의 CI / CD

CI 와 CD를 분리했다.

GitHub Action으로 CI : 머지가 되기전에 테스트와 빌드가 가능한지 미리 확인한다.

Jenkins가 CD를 진행 : 머지가 된 시점에 빌드가 정상적으로 되고 테스트가 되는지 확인한다.



crontab으로 ci/cd 구현

10분마다 git rev-parse를 통해 local 과 origin을 비교해서 pull 하고 배포를 한다.



docker를 이용해서 Jenkins를 띄운 이유:

여러 PC에 하는것도 아니고, 간편하다는 것 말고는 뚜렷한 이유는 없다.

