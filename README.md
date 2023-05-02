# spring-microservices
<b>Spring microservices using api gateway, eureka, zipkin, config server, resilience4j, circuit breaker, jwt</b>

<b>Stat the project in the following sequence</b>

Zipkin server
Discovery server
Config Server
Microservices(Authentication service, Department service, Employee service)
Api gateway

This project uses the httpexchange for inter micro services communication and also jwt to make sure all the microservices are accessed only by registered users.

api-gateway runs on port 8078 and this is the entry point for all the requests.

<b>step1 : Register the user</b>

HTTP VERB: POST 
URL: http://localhost:8078/auth/save 
JSON Payload: 
{
    "name":"Tanson",
    "email":"x@x.com",
    "password":""
}

<b>Step 2: Get the token for registered user</b>

HTTP VERB: POST 
URL: http://localhost:8078/auth/token 
JSON Payload: 
{
    "name":"Tanson",
    "password":""
}

<b>Step 3: Hit the required microservice via api gateway and pass the token as Bearer</b>

HTTP VERB: POST 
URL: http://localhost:8078/emp/save
Authorisation type: Bearer Token
JSON Payload: 
{
    "id":"1",
    "deptId":"1",
    "name":"Thomas",
    "age":"30",
    "position":"SSE"
}

HTTP VERB: GET 
Authorisation type: Bearer Token
URL: localhost:8078/emp/findAll

credits youtube channels: #java techie, #daily code buffer
