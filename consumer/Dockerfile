FROM eclipse-temurin:17-jdk-alpine
WORKDIR /consumer

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY messages_1.txt ./
COPY messages_2.txt ./

RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
