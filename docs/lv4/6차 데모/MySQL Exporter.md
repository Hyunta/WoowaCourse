```mysql
CREATE USER 'exporter'@'localhost' IDENTIFIED BY 'password' WITH MAX_USER_CONNECTIONS 3;
GRANT PROCESS, REPLICATION CLIENT, SELECT ON *.* TO 'exporter'@'localhost';
```

```linux
export DATA_SOURCE_NAME='exporter:password@(localhost:8080)/'
```

exporter.go:149 level=error msg="Error pinging mysqld" err="dial tcp 127.0.0.1:3306: connect: connection refused"

해결완료 3306 -> 8080 으로 해결



