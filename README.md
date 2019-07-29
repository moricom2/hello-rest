# Docker-ce
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



# gitLab Runner
> #docker run -d --name gitlab-runner -v /var/run/docker.sock:/var/run/docker.sock -v /etc/docker/daemon.json:/etc/docker/daemon.json -v /data/runner1/gitlab-runner/config:/etc/gitlab-runner gitlab/gitlab-runner:latest  


> docker run -d --name gitlab-runner -v /var/run/docker.sock:/var/run/docker.sock -v /etc/docker/daemon.json:/etc/docker/daemon.json gitlab/gitlab-runner:latest  

> docker exec -it gitlab-runner bash  
>> gitlab-runner register  

