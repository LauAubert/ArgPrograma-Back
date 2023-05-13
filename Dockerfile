FROM openjdk:17-jdk-alpine
EXPOSE 8080
RUN ls
COPY ./target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]

