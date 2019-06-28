FROM openjdk:8-jre
COPY target/HelloRest*.jar hello-rest.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/hello-rest.jar"]
