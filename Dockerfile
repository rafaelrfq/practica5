FROM adoptopenjdk/openjdk11:alpine-jre

LABEL maintainer="Rafael Felipe <20100748@ce.pucmm.edu.do>"

VOLUME /tmp

EXPOSE 61616 8080

COPY /build/libs/*.jar practica5-web.jar

ENTRYPOINT ["java", "-jar", "practica5-web.jar"]