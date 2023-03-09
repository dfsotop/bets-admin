# Bets Administrator
Project developed as a Proof Of Concept 
in order to solve the challenge purposed by 
amusnet

## Architecture
This project is designed with a CQRS/ES architecture, thus takes advantage of the infrastructure and framework
[Axon](https://docs.axoniq.io/reference-guide/architecture-overview) for its development

A simplified Components diagram is shown for general understanding

![Bets-Admin.drawio.png](src%2Fmain%2Fresources%2Fstatic%2FBets-Admin.drawio.png)

## Requisites
- Docker
- Java 8+
- Maven 3.6+
- Axon server

## Get Started
- Clone this repository `git clone https://github.com/dfsotop/bets-admin`
- Make sure Docker is running
- execute: `docker run -d --name axon-server -p 8024:8024 -p 8124:8124 axoniq/axonserver`
- execute: `mvn clean package`
- execute: `java -jar target/app.jar`

## Execution
This API is documented with Swagger2.

With the API running you can go to http://localhost:8080/swagger-ui.html
to inspect the endpoints documentation and interact with the API.

## Dockerize
To dockerize this application execute `mvn spring-boot:build-image`. This will create an image ready to execute in docker.


## Disclaimers
- `gameId` is assumed to be controlled outside the api such as, it is not controlled for this purpose.
- Each Event is related to a `playerId`, hence, the player must be created before any transaction. 
Furthermore, every transaction must contain a valid `playerId` 
- The read is done over a denormalized view. 
The intention is not design a Relational DataBase, but an API able to deal scalability and multiple parallel requests
- The persistence is delegated on the Axon Server, but the domain design can work potentially on any E/R DB Engine
- Tests are included for the most crucial Classes. This PoC is not focused in Unit Tests, 
but in the architecture designing.

