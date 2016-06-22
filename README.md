# Echo

最简单的 Maven Jetty Plugin

required:
Java7 Servlet3 Maven3 

## 运行

`mvn jetty:run`

## 访问 hello jetty

`curl localhost:8080`

## 访问 echo

`curl localhost:8080/echo?name=jetty`

## 访问 echo post

`## 访问 echo
 
 访问 `curl -sX POST --data @person.json localhost:8080/echo`

