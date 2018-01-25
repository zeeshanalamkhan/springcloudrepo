FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD target/patient-service-1.0.jar patient-service.jar
EXPOSE 8090
ENTRY POINT ["java","-jar","/patient-service.jar"]
