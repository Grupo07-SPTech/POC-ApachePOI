# Etapa 1: compilar o projeto
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copia as configurações do Maven
COPY pom.xml .

# Copia o código-fonte
COPY src ./src

# Gera o JAR executável com as dependências
RUN mvn clean package -DskipTests

# Etapa 2: executar a aplicação
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY --from=build /app/target/*.jar-with-dependencies ./app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
