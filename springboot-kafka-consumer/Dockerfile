FROM openjdk:17-jdk-alpine
COPY target/springboot-kafka-consumer-0.0.1-SNAPSHOT.jar kafka-consumer-1.0.0.jar
ENTRYPOINT ["java","-jar","/kafka-consumer-1.0.0.jar"]