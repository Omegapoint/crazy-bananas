#!/usr/bin/env bash

mvn package

./run_service.sh "secret.SecretService" 1111
./run_service.sh "sun.SunService" 2222
./run_service.sh "source.WaterService" 3333
./run_service.sh "source.WaterService" 3334
./run_service.sh "plant.BananaService" 4444
