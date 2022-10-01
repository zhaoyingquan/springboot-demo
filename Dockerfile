FROM openjdk:11
EXPOSE 8081
COPY ./target/springboot_demo-0.0.1-SNAPSHOT.jar /springboot.jar
ENTRYPOINT ["java","-jar","/springboot.jar"]
