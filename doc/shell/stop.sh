#!/bin/bash
PID=$(ps -ef | grep microservice-discovery-0.0.1.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi