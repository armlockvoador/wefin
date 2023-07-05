FROM openjdk:17
ADD target/wefindb-app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]