FROM maven:3.8.1-jdk-11 as BUILD
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=BUILD /app/target/*.jar  application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]