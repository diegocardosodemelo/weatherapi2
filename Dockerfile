FROM openjdk:11
EXPOSE 8080
ADD target/weatherapi.jar weatherapi.jar
ENTRYPOINT ["java","-jar","/weatherapi.jar"]