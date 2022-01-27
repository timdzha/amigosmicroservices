Maven Lifecycle
- package - take the copmiled code and package it to jar/war distributable format
- install - install the package into local repository, 
for use as a dependency in other projects locally
check it in maven local repository

The POM for timdev.amigoscode:amqp:jar:1.0-SNAPSHOT is missing, no dependency information available
The POM for timdev.amigoscode:clients:jar:1.0-SNAPSHOT is missing, no dependency information available
 - install

`no-main-manifest-attribute-maven` error when try to run MS using
`java -jar .\api-gateway\target\api-gateway-1.0-SNAPSHOT.jar`

https://stackoverflow.com/questions/54867295/springboot-no-main-manifest-attribute-maven

- create an access token in docker hub
- login to own docker hub account
`docker login`
- clean and package with profile `docker-build-image`
`mvn clean package -P build-docker-image`
same as in IDEA Maven-Lifecycle-clean-then-package