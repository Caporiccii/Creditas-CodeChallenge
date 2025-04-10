# Imagem base com JDK 21 e Maven
FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Instala ktlint (opcional para build)
RUN curl -sSLo ktlint https://github.com/pinterest/ktlint/releases/download/1.1.1/ktlint \
    && chmod +x ktlint \
    && ./ktlint "**/*.kt" || true

# Compila o projeto com Maven
RUN ./mvnw clean install -DskipTests

# ---------- Runtime Layer ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o jar da build anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
