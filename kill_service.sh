#!/usr/bin/env bash

SERVICE="$1"

PIDS=$(ps -e | grep -v grep | grep -v bash | grep "$SERVICE" | cut -d ' ' -f 1)

kill $PIDS