FROM java:8
EXPOSE 8090
ADD target/Customer-0.0.1-SNAPSHOT.jar customer.jar 
ENTRYPOINT ["java" , "-jar" , "customer.jar" ]