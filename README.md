###banner
[create spring boot banner](https://devops.datenkollektiv.de/banner.txt/index.html) 
then generate the banner and place it to the `resources/banner.txt`  

###start docker services
`cd {root of the project where docker-compose.yml placed}`   
run `docker compose up -d`  
check running `docker compose ps`  
go to pgAdmin webUI `localhost:5050`  
add NewServer with any name and hostName/address = postgres  
we set `hostName` as `postgres`(it's a `network`), 
because `pgAdmin service` and `postgres service` 
connect with each other inside the `docker container` by `network = postgres`

###register new customer
`curl --location --request POST 'localhost:8080/api/v1/customers' --header 'Content-Type: application/json' --data-raw '{"firstName": "tim","lastName": "dzha","email": "tim@gmail.com"}'`

##Customer and FraudCheck microservices communication
###Customer running on 8080 and  FraudCheck running 8081 port
1. One To One Instance Rest Communication
![one-to-one-instance-rest-communication](resources/one-to-one-instance-rest-communication.png)

2. One To Many Instances Rest Communication
![one-to-many-instance-rest-communication](resources/one-to-many-instance-rest-communication.png)
It's hard for Customer service discover all FraudCheck services  
Let's use Eureka Server
![eureka-service-discovery-example](resources/eureka-service-discovery-example.png)

In our projects the diagram will looks like that
![eureka-service-discovery](resources/eureka-service-discovery.png)

Eureka Server running on 8761.  
We see dashboard  

But we should understand that Eureka Server now seems like a bottle-neck.   
If it falls down, all microservices will fail. 
