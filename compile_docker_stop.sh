#!/bin/bash

docker rm --force education-compile-1 1>/dev/null 2>&1

docker rmi labcomu/education-compile
