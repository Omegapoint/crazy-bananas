#!/usr/bin/env bash

kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas.secret.SecretService | cut -d ' ' -f 1)
kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas.sun.SunService | cut -d ' ' -f 1)
kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas.source.WaterService | cut -d ' ' -f 1)
kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas.plant.BananaService | cut -d ' ' -f 1)