#!/bin/bash

PROFILE=default

for APP in discovery-server orcid-service org-service edu-service
do
  java -jar -Dspring.profiles.active=${PROFILE} ${APP}/target/${APP}.jar &
done
