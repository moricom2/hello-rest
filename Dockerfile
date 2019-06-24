FROM openjdk:8-jdk
ADD target/HelloRest-0.0.1-SNAPSHOT.jar hello-rest.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/hello-rest.jar"]
