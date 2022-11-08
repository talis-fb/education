#!/bin/bash

local() {
  echo "LOCAL"
}

docker() {
  echo "DOCKER"
}

. ./do.sh Echo $@