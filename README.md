# orcid

http://localhost:8761/

http://localhost:8081/service-instances/orcid-service

https://www.baeldung.com/spring-cloud-netflix-eureka

https://github.com/eugenp/tutorials/tree/master/spring-cloud-modules/spring-cloud-eureka

https://resilience4j.readme.io/docs/getting-started-3

https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/spring-cloud-circuitbreaker-resilience4j.html

https://betterprogramming.pub/implementing-reactive-circuit-breaker-using-resilience4j-4fe81d28e100

https://github.com/resilience4j/resilience4j-spring-boot2-demo


docker build --tag discovery-server .
docker rm --force discovery-server 1>/dev/null 2>&1
#docker create --interactive --tty --publish 8761:8761 --name discovery-server discovery-server
docker create --publish 8761:8761 --name discovery-server discovery-server
#docker start --interactive discovery-server
docker start discovery-server

docker compose up --detach


https://github.com/docker/compose/issues/4950

http://localhost:8281/h2-console
