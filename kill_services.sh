#!/usr/bin/env bash

kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas | sed -e 's/^[ \t]*//' | cut -d ' ' -f 1)
