#!/bin/bash

docker build --file Dockerfile.compile --tag labcomu/education-compile .

## --interactive --tty --entrypoint=/bin/sh
docker create --volume ${PWD}:/app --name education-compile-1 labcomu/education-compile

docker start education-compile-1

docker attach education-compile-1