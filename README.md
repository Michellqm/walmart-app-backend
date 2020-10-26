# Wallmart app test - Backend | JAVA


### Installation

* Clonar el repositorio
* Clonar y levantar la imagen de mongo contenida en el repositorio de prueba https://github.com/walmartdigital/products-db
* Modificar Dockerfile 
* Cambiar: 
```sh
ENTRYPOINT ["java","-Dserver.port=$PORT", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
```
* Por
```sh
ENTRYPOINT ["java","-Dserver.port=8081", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
```

* Build docker image
```sh
docker build --pull --rm -f Dockerfile --tag wallmart-app/jdk11 . 
```
* Run docker image
 ```sh
docker run  --env ENVIROMENT=local  --network="host" -it wallmart-app/jdk11
```

## Para testear 
 ```sh
http://localhost:8081/v1/product?id=5
http://localhost:8081/v1/products?item=ooo&discount=false
```