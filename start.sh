#!/bin/bash

do_local() {
  PROFILE=default

  for APP in discovery-server orcid-service org-service edu-service
  do
    java -jar -Dspring.profiles.active=${PROFILE} ${APP}/target/${APP}.jar &
  done
}

do_docker() {
  docker compose up --detach --file
}

. ./do.sh Start $@