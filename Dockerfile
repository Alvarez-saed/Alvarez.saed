FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

# ✅ Busca el .jar donde realmente lo genera
RUN ls -la build/
RUN ls -la build/libs/

COPY build/libs/crud-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]