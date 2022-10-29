- DBMS와 DB의 차이
- 엑셀을 안쓰고 DBMS를 쓴 이유?



### DBMS

DB는 구조화된 정보 또는 데이터의 조직화된 모음이며, 이를 관리하는 시스템을 DBMS라고 함



### 트랜잭션

- 논리적 작업 단위
- ACID 속성 (암기)

DBMS만 써도 다 이뤄진다.



- innodb와 myisam의 차이



### 격리 수준(isolation level)

Uncommited Read - 커밋 안된 것도 읽는다

Commited Read - 커밋된것만 읽는다

Repeatable Read - 한 트랜잭션 내에서 같은 읽기에 대한 같은 결과를 보장한다.

Serializable - 직렬화 가능하다. 트랜잭션의 모든 단계에 Lock을 걸어서 항상 트랜잭션의 순서를 직렬화한다.



mysql은 PhantomRead가 발생하지 않는다.

MVCC 를 찾아보자, 왜 PhantomRead를 방지할 수 있는지





### 인덱스

- 테이블에 대한 동작 속도를 높여주는 자료 구조
- 컬럼 값과 해당 레코드가 저장된 주소를 key와 value의 쌍으로 삼아 만듦
- MySQL InnoDB의 경우 B-Tree 인덱스 구조를 사용



B-Tree

- 범위 검색 가능

- Key가 너무 커지면 페이지에 담을 수 있는 데이터가 줄어든다.

Hash

- 범위 조건 검색 불가능, 해시 충돌,  데이터 저장이 비효율적
- 정확히 일치하는 데이터는 빠르다
- 범위검색 혹은 Like가 불가능하다.
- 블럭단위로 관리하기 까다롭다.



### 인덱스 구분

- mysql은 key에 대해서 index로 만들어놓는다.
- key를 row를 식별하기 위함
- index는 속도를 향상시키기 위함

- clustered index
- InnoDB의 경우 아래 컬럼을 clustered index로 사용
  - primary Key
  - unique & not null column
  - 내부적으로 생성한 GEN_CLUST_INDEX



### 인덱스 한번 더 생각해보기

트레이드 오프

- 저장 성능을 희생하고 대신 읽기 성능을 높이는 기능
- 데이터 저장 후 추가로 인덱스를 변경해야 함
- 메모리를 추가로 사용해야 함



인덱스를 사용할 수 없는 경우

- <>. NOT IN, NOT BETWEEN, IS NOT NULL
- LIKE "%?"

다른 순서로 데이터에 접근하는게, 기존 순서를 유지하는 것보다 오래걸린다. 그래서 인덱스를 쓰면 오히려 느리다.



explain <Query>

에서 나오는 type Column의 값들은 알아야 한다.

- const
- eq_ref
- ref
- range
- index
- all

순서대로 느려진다.



### nginx

- 워커 프로세스, 싱글 스레드 구조로 컨텍스트 스위치 비용이 발생하지 않음
- node의 이벤트 루프





