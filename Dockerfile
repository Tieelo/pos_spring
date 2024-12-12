FROM eclipse-temurin:23-alpine

USER root

RUN apk upgrade --no-cache &&\
    apk add --no-cache bash curl shadow gettext

COPY  /deployment/ /opt/
RUN chmod 775 -R /opt/

CMD ["java", "-jar", "/opt/app.jar", "--spring.config.location=/opt/application.properties"]