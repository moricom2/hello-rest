# springboot hello-rest

1. git clone https://github.com/moricom2/hello-rest.git
2. cd hello-rest
( vi src/main/java/com/example/hellorest/index/IndexController.java )
3. mvn clean package -DskipTests=true
4. docker build -t moricom/hello-rest .
5. docker push moricom/hello-rest




https://hub.docker.com/r/moricom/hello-rest

1. docker pull moricom/hello-rest
2. docker run -d -p 80:80 --rm --name hello-rest moricom/hello-rest
