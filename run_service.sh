#!/usr/bin/env bash

SERVICE=$1

mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.$SERVICE" &
