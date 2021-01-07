FROM java:8
EXPOSE 8081
ADD target/Stock-0.0.1-SNAPSHOT.jar Stock.jar
ENTRYPOINT ["java","-jar","Stock.jar"]