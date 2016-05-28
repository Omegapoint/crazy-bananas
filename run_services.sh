#!/usr/bin/env bash

mvn package

./run_service.sh "secret.SecretService"
./run_service.sh "sun.SunService"
./run_service.sh "source.WaterService"
./run_service.sh "plant.BananaService"
