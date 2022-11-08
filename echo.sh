#!/bin/bash

do_local() {
  echo "LOCAL"
}

do_docker() {
  echo "DOCKER"
}

. ./do.sh Echo $@