FROM openjdk:8-jre
ADD target/ROOT.jar ROOT.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/ROOT.jar"]
