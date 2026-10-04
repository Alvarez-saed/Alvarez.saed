FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

# ✅ Toma el archivo .jar más reciente y lo renombra
RUN ls -t build/libs/*.jar | head -n 1 | xargs -I {} cp {} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]