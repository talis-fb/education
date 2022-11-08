#!/bin/bash

do_local() {
  for PORT in 8181 8281 8381 8761
  do
    curl -X POST http://localhost:${PORT}/actuator/shutdown
  done
}

do_docker() {
  docker compose down --rmi local
}

. ./do.sh Start $@