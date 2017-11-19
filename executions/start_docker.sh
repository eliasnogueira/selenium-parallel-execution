#!/bin/bash

# upgrades to latest if a newer version is available
docker pull elgalu/selenium

# run docker container
docker run -d --name=grid -p 4444:24444 -p 5900:25900 \
     -e TZ="America/Sao_Paulo" -e VNC_PASSWORD=passwd -v /dev/shm:/dev/shm --privileged elgalu/selenium