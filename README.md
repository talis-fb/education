# education

## Diagrams

### Components

![Component Diagram](education-component.drawio.png)

### Deployment

![Deployment Diagram](education-deployment.drawio.png)

## Requirements
* Java 19 + Maven **and/or**
* Docker Desktop 4.12.0
  * Configure project root directory on Docker Desktop (Settings > Resources > Advanced > File Sharing)

## Commands (use Git Bash)
* `./compile.sh [--local|--docker]`
* `./start.sh [--local|--docker]`
* `./stop.sh [--local|--docker]`
* `./test.sh [--local|--docker]`

## URL
* Discovery Server: http://localhost:8761
* Discovery Client: http://localhost:8081/service-instances/orcid-service
* H2 Database: http://localhost:8281/h2-console

## Testing
* Postman file: education.postman_collection.json
* IntelliJ: orcid-service.http, org-service.http, edu-service.http
* Script: `./test.sh [--local|--docker]`



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






