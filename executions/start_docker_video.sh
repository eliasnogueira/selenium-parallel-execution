#!/bin/bash

# upgrades to latest if a newer version is available
docker pull elgalu/selenium

# run docker container
docker run --rm --name=grid -p 4444:24444 -p 5920:25900 \
  --shm-size=1g -e VNC_PASSWORD=passwd \
  -e VIDEO=true elgalu/selenium