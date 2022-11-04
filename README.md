# education

## Requirements
* Java 19 + Maven
* Docker Desktop

## Run

* mvn clean install
* ./start.sh 
  * shell script (use within Git Bash under Windows)

## URL

* Discovery Server: http://localhost:8761
* Discovery Client: http://localhost:8081/service-instances/orcid-service
* H2 Database: http://localhost:8281/h2-console

## Testing

* Postman file: education.postman_collection.json
* IntelliJ: orcid-service.http, org-service.http, edu-service.http

# Links

## Eureka (Discovery Server)
* https://www.baeldung.com/spring-cloud-netflix-eureka
* https://github.com/eugenp/tutorials/tree/master/spring-cloud-modules/spring-cloud-eureka

## Resilience4J
* https://resilience4j.readme.io/docs

### Resilience4J + Spring Cloud

* https://reflectoring.io/rate-limiting-with-springboot-resilience4j
* https://reflectoring.io/retry-with-springboot-resilience4j
* https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/spring-cloud-circuitbreaker-resilience4j.html
* https://betterprogramming.pub/implementing-reactive-circuit-breaker-using-resilience4j-4fe81d28e100

## Others

* https://github.com/docker/compose/issues/4950






