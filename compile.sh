#!/bin/bash

local() {
  mvn clean install
}

docker() {
  echo 1
  ./compile_docker_start.sh
  ./compile_docker_stop.sh
}

. ./do.sh Compile $@