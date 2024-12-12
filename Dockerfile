FROM eclipse-temurin:23-alpine

USER root

RUN apk upgrade --no-cache &&\
    apk add --no-cache bash curl shadow gettext

COPY  /deployment/ /tmp/
RUN chmod 775 -R /tmp/ && chmod +x /tmp/entrypoint.sh

ENTRYPOINT ["/tmp/entrypoint.sh"]