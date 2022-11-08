#!/bin/bash

usage() {
  OPERATION=${1}
  USAGE="
	Usage: ${0} [OPTION]                                \n
                                                      \n
	 where options include:                             \n
	  -l, --local   ${OPERATION} on local environment   \n
	  -d, --docker  ${OPERATION} on docker container(s) "
  echo -e ${USAGE}
  exit 1
}

#local() {
#  echo "LOCAL"
#}
#
#docker() {
#  echo "DOCKER"
#}

[ $# -lt 1 ] && echo "Invalid usage of do.sh" && exit 2

OPERATION="${1}"
shift

[ $# -lt 1 ] && usage ${OPERATION}

while [[ $# > 0 ]]
do
  option="${1}"
  case ${option} in
      -l|--local)
        local
        shift
      ;;
      -d|--docker)
        docker
        shift
      ;;
      *) # unknown option
        usage ${OPERATION}
      ;;
  esac
done