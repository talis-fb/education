#!/bin/bash

do_local() {
  mvn clean install
}

do_docker() {
  echo 1
  ./compile_docker_start.sh
  ./compile_docker_stop.sh
}

. ./do.sh Compile $@