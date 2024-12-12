#!/bin/bash

envsubst < /tmp/template.properties > /tmp/application.properties

exec java \
    "${JAVA_OPTIONAL_ARGS:--DJAVA_OPTIONAL_ARGS=disabled}" \
    -jar /tmp/app.jar --spring.config.location=file:/tmp/application.properties