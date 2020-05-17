FROM adoptopenjdk/openjdk13
VOLUME /tmp
COPY target/demo-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
