## Concurrency

Server는 여러 사람이 접근할 수 있어야 한다. 따라서 동시성 이슈는 무조건 해결해야하는 이슈



### Process & Thread

각 프로세스가 고유한 영역을 가진다.

JVM은 보통 단일 프로세스에서 작동한다.

Thread는 하나의 프로세스에서 작동한다. 같은 메모리를 사용한다.

데이터를 공유할 수 있다.



### Synchronization

- 쓰레드 간섭
- 메서드 일관성 오류



### Thread-safe class

- 상태 변수를 스레드 간에 공유하지 않는다.
- 상태 변수를 변경할 수 없도록 만든다.
- 상태 변수에 접근할 땐 언제나 동기화를 사용한다.
- 캡슐화나 데이터 은닉은 스레드 안전한 클래스 작성에 도움이 된다.





### Tomcat 환경설정

- accept-count

  maxConnections에 도달하게 되면 os에서 제공하는 request queue의 최대 길이를 정의한다. os에서 이 설정값을 무시할 수도 있다. Queue가 가득차면 추가 connections를 거절할 수 있다. 기본값은 100이다.

- maxConnections

  정해진 시간에 Server가 수용할 connection의 최대 갯수. maxConnection에 도달하면 server는 수용하지만 진행시키지는 않는다. maxConnection보다 떨어질때까지 기다리고 떨어지면 진행시킨다.

- maxThread

  톰캣 내의 쓰레드 수를 결정하는 옵션, 쓰레드의 수는 activerUser을 의미한다. 기본값은 200이다.









