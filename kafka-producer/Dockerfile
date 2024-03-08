FROM openjdk:17-jdk-alpine
COPY target/springboot-kafka-producer-0.0.1-SNAPSHOT.jar kafka-producer-1.0.0.jar
ENTRYPOINT ["java","-jar","/kafka-producer-1.0.0.jar"]