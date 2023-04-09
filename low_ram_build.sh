#!/usr/bin/env bash

YELLOW='\033[0;33m'
NC='\033[0m'
GREEN='\033[0;32m'


printf ${YELLOW}"===Building registry-service===/n"${NC}
cd server/registry-service;
docker build -t registry-service .;
printf ${GREEN}"===Registry-service build completed==="${NC}

