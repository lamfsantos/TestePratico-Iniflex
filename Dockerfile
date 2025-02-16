FROM openjdk:21-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY arquivos ./arquivos

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/TestePratico-Iniflex-1.0-SNAPSHOT.jar"]