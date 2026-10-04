FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew bootJar -x test --no-daemon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/crud-0.0.1-SNAPSHOT.jar"]