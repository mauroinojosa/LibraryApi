FROM openjdk:17-jdk-alpine

RUN mkdir /bibliotecaAPP

WORKDIR /bibliotecaAPP

RUN apk add --no-cache bash


COPY target/*.jar /bibliotecaAPP/bibliotecaAPI.jar

COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-it.sh", "mysql:3307", "--", "java", "-jar", "bibliotecaAPI.jar"]


