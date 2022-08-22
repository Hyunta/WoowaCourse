## 학습 동기

4차 데모 요구사항에 `CloudWatch logs 대시보드를 구성한다` 가 추가되었다. CloudWatch란 AWS 리소스 및 AWS에서 실행되는 애플리케이션을 실시간으로 모니터링하는 서비스다. CloudWatch를 사용하게 되면 시스템 전체의 리소스 사용률, 애플리케이션 성능, 운영 상태를 파악할 수 있다. 우리는 CPU 사용률, 메모리 사용률, 네트워크 송수신 상태와 출력된 로그들을 볼 수 있도록 설정을 할 것이다.



## 준비

CloudWatch를 시험해보기 위해서 EC2 인스턴스를 하나 만든다. 그리고 로그를 남기는 예시 프로젝트를 하나 만들어준다. 해당 EC2에 예시 프로젝트를 실행시켜서 로그 파일을 생성하도록 만들면 준비는 끝이다.



## 사전 정보

![image-20220811111016407](/Users/kimhyuntae/Desktop/image-20220811111016407.png)

자료를 찾다보니 metric과 log를 따로 수집하는 Agent와 통합해서 한번에 받아오는 Agent가 있었습니다. 전자는 예전 방식이고 사용 중단되는 과정에 있어서 python 구버전이 필요하고, setUp하면서 문제가 많이 발생합니다. AWS에서도 권장하지 않는 방식이니 권장하는 방식으로 진행하면 훨씬 수월하게 setUp 가능합니다.



## EC2 인스턴스에 IAM 역할 생성

https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/create-iam-roles-for-cloudwatch-agent.html#create-iam-roles-for-cloudwatch-agent-roles

![image-20220811111459712](/Users/kimhyuntae/Desktop/image-20220811111459712.png)



