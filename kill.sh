#!/bin/bash

do_local() {
  for PORT in 8181 8281 8381 8761
  do
      kill $(lsof -t -i:${PORT})
  done
}

do_docker() {
  docker compose down --rmi local
}

. ./do.sh Start $@