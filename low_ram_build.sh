#!/usr/bin/env bash

YELLOW='\033[0;33m'
NC='\033[0m'
GREEN='\033[0;32m'


docker build -t registry-service ./server/registry-service;

docker build -t config-service ./server/config-service;

docker build -t gateway-service ./server/gateway-service;


printf ${GREEN}"===Fnd_games_store build completed===/n"${NC}
