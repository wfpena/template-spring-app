FROM adoptopenjdk/openjdk11:latest
COPY . app/
WORKDIR /app
RUN ./mvnw install
RUN cp application.properties ./target/application.properties
ENTRYPOINT ["java","-jar","./target/shop-0.0.1-SNAPSHOT.jar"]
