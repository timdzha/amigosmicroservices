# Docker services by docker-compose.yml
## Start postgresql and pgadmin
[link to docker-compose](docker-compose.yml)  
`cd {root of the project where docker-compose.yml placed}`   
run `docker compose up -d`  
check running `docker compose ps`  
go to pgAdmin webUI `localhost:5050`  
add NewServer with any name and hostName/address = postgres  
we set `hostName` as `postgres`(it's a `network`),
because `pgAdmin service` and `postgres service`
connect with each other inside the `docker container` by `network = postgres`
use `docker logs {container name}` to see logs

## Start zipkin
[link to Zipkin](https://zipkin.io/pages/quickstart)  
add to docker compose file zipkin service and start  
[Zipkin runs on http://127.0.0.1:9411/zipkin/](http://127.0.0.1:9411/zipkin/)  
