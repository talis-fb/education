#!/bin/bash

do_local() {
  for APP in discovery-server orcid-service org-service edu-service
  do
      ps -aux | grep ${APP} | grep -v grep | awk '{print $2}' | xargs kill
  done
}

do_docker() {
  docker compose down --rmi local
}

. ./do.sh Start $@