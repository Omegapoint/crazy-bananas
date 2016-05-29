#!/usr/bin/env bash

INVERTED_PROBABILITY=3

while true; do
    for SERVICE in $@; do
        PIDS=$(ps -e | grep -v grep | grep -v bash | grep "$SERVICE" | cut -d ' ' -f 1)
        echo "Monkey found ${PIDS:-none} for $SERVICE"
        UNLUCKY=$(jot -r 1 0 $INVERTED_PROBABILITY)
        array_of_pids=($PIDS)
        UNLUCKY_PID=${array_of_pids[UNLUCKY]}
        echo "Monkey killing" ${UNLUCKY_PID:-"none"}
        kill $UNLUCKY_PID 2&>1 /dev/null
    done
    echo "Monkey resting for a while"
    sleep_time=$(jot -r 1 3 20)
    for i in $(seq 1 $sleep_time); do
        echo -n "."
        sleep 1
    done
    echo
done