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