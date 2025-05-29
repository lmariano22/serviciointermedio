#!/usr/bin/env bash
export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
./mvnw clean package