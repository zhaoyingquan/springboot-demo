FROM openjdk:11
EXPOSE 8081
COPY springboot.jar /springboot.jar
ENTRYPOINT ["java","-jar","/springboot.jar"]