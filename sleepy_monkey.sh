#!/usr/bin/env bash

PORTS="$@"
MAX_SLEEP_TIME="30000"

while true; do
    echo "Monkey found ${PIDS:-none} for $SERVICE"
    UNLUCKY=`jot -r 1 0 $#`
    UNLUCKY_SERVICE=${!UNLUCKY}
    SERVICE_SLEEP_TIME=$(jot -r 1 0 $MAX_SLEEP_TIME)
    echo "Monkey delaying service on port "${UNLUCKY_SERVICE:-"none"} "with" $SERVICE_SLEEP_TIME "millis"
    curl -X PUT http://localhost:5555/sleep/$UNLUCKY_SERVICE?time=$SERVICE_SLEEP_TIME 2&> /dev/null
    echo "Monkey resting for a while"
    sleep_time=$(jot -r 1 3 20)
    for i in $(seq 1 $sleep_time); do
        echo -n "."
        sleep 1
    done
    echo
done