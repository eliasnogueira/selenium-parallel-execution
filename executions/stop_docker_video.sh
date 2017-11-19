#!/bin/bash

docker exec grid stop-video
mkdir -p ./videos
docker cp grid:/videos/. videos

docker exec grid stop
docker stop grid