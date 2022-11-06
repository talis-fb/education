#!/bin/bash

#for PORT in 8181 8281 8381 8761
#do
  #curl -X POST http://localhost:${PORT}/actuator/shutdown
  #kill $(lsof -t -i:${PORT})
#done

for APP in discovery-server orcid-service org-service edu-service
do
  ps -aux | grep ${APP} | grep -v grep | awk '{print $2}' | xargs kill
done
