#!/usr/bin/env bash

kill $(ps -e | grep -v grep | grep se.omegapoint.crazy.bananas | cut -d ' ' -f 1)
