#!/usr/bin/env bash

SERVICE=$1
PORT=$2

mvn exec:java -Dexec.mainClass="se.omegapoint.crazy.bananas.$SERVICE" -Dport="$PORT" &
