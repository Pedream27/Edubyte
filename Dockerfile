# Usa imagem do Java 21 com JDK
FROM eclipse-temurin:21-jdk as build

# Define diretório de trabalho
WORKDIR /app

# Copia arquivos do projeto
COPY . .

# Compila o projeto com Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Etapa final: cria imagem mínima com JRE apenas
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia JAR do build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
