FROM amazoncorretto:11-alpine-jdk
MAINTAINER baeldung.com
COPY target/profile-0.0.1-SNAPSHOT.jar profile-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/profile-0.0.1-SNAPSHOT.jar"]