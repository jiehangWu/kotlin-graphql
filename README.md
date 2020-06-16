# Kotlin-Graphql
This is a Graphql server built with Spring Boot and Kotlin. This app connects to a local MongoDB server. This server listens on port ```8080```.
## Endpoints
Unlike RESTful API, all of the requests go to ```/graphql``` or ```/graphiql```, depending on which one is enabled.<br> 
Currently, this server supports querying for all the teams and players that has a team. The app also supports mutations for inserting, updating, and deleting a team. 
## How to build
```./gradlew bootRun```
