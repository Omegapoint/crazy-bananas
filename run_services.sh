#!/usr/bin/env bash

mvn package

mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.secret.SecretService" &
mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.sun.SunService" &
mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.source.WaterService" &
mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.plant.BananaService" &
